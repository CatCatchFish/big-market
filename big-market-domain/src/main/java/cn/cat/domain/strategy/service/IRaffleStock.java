package cn.cat.domain.strategy.service;

import cn.cat.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

/**
 * 抽奖库存相关接口，获取库存、消耗队列
 */
public interface IRaffleStock {

    /**
     * 获取奖品库存消耗队列
     *
     * @return 奖品库存key信息
     */
    StrategyAwardStockKeyVO takeQueueValue();

    /**
     * 更新奖品库存消耗记录
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

}
