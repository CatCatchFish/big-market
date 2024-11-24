package cn.cat.domain.strategy.service.rule.tree.factory.engine;

import cn.cat.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * 规则数组合接口
 */
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId, Date endDateTime);
}
