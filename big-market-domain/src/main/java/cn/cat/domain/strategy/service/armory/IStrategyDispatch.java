package cn.cat.domain.strategy.service.armory;

import java.util.Date;

public interface IStrategyDispatch {
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeight);

    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(Long strategyId, Integer awardId, Date endDateTime);
}
