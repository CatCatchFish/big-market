package cn.cat.domain.strategy.repository;

import cn.cat.domain.strategy.model.entity.StrategyAwardEntity;
import cn.cat.domain.strategy.model.entity.StrategyEntity;
import cn.cat.domain.strategy.model.entity.StrategyRuleEntity;
import cn.cat.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.util.List;
import java.util.Map;

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String strategyId, int size, Map<Integer, Integer> shuffleStrategyAwardSearchRateTable);

    Integer getRateRange(String strategyId);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);
}
