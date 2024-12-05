package cn.cat.domain.strategy.service.rule.chain;

import cn.cat.domain.strategy.service.rule.chain.factory.DefaultLogicChainFactory;

public interface ILogicChain extends ILogicChainLink, Cloneable {
    DefaultLogicChainFactory.StrategyAwardVO logic(String userId, Long strategyId);
}
