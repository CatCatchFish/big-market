package cn.cat.domain.strategy.repository;

import cn.cat.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;
import java.util.Map;

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String strategyId, int size, Map<Integer, Integer> shuffleStrategyAwardSearchRateTable);

    Integer getRateRange(String s);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);
}
