package cn.cat.domain.strategy.service.armory;

public interface IStrategyArmory {
    boolean assembleLotteryStrategy(Long strategyId);

    boolean assembleLotteryStrategyByActivityId(Long activityId);
}
