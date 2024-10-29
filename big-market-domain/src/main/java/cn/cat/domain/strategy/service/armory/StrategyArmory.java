package cn.cat.domain.strategy.service.armory;

import cn.cat.domain.strategy.model.entity.StrategyAwardEntity;
import cn.cat.domain.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

@Service
public class StrategyArmory implements IStrategyArmory {
    // 调用repository层
    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public void assembleLotteryStrategy(Long strategyId) {
        // 1.查询策略奖品列表
        List<StrategyAwardEntity> strategyAwardEntities = strategyRepository.queryStrategyAwardList(strategyId);

        // 2.获取最小策略概率
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // 3.获取概率范围
        BigDecimal rateRange = BigDecimal.valueOf(convert(minAwardRate.doubleValue()));

        // 4.生成奖品查找表
        List<Integer> strategyAwardSearchRateTables = getIntegers(rateRange, strategyAwardEntities);

        // 5.对存储的奖品进行乱序操作
        Collections.shuffle(strategyAwardSearchRateTables);

        Map<Integer, Integer> shuffleStrategyAwardSearchRateTable = new LinkedHashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTable.put(i, strategyAwardSearchRateTables.get(i));
        }

        // 6. 存放到 Redis
        strategyRepository.storeStrategyAwardSearchRateTable(String.valueOf(strategyId), shuffleStrategyAwardSearchRateTable.size(), shuffleStrategyAwardSearchRateTable);
    }

    @Override
    public Integer getRandomAwardId(Long strategyId) {
        int rateRange = strategyRepository.getRateRange(String.valueOf(strategyId));
        return strategyRepository.getStrategyAwardAssemble(String.valueOf(strategyId), new SecureRandom().nextInt(rateRange));
    }

    private static List<Integer> getIntegers(BigDecimal rateRange, List<StrategyAwardEntity> strategyAwardEntities) {
        List<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            // 计算出每个概率值需要存放到查找表的数量，循环填充
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }
        }
        return strategyAwardSearchRateTables;
    }

    private double convert(double min) {
        double current = min;
        double max = 1;
        while (current < 1) {
            current = current * 10;
            max = max * 10;
        }
        return max;
    }

}
