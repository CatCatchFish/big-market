package cn.cat.domain.strategy.service.rule.chain;

import cn.cat.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

public interface ILogicChain extends ILogicChainLink {
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);
}
