package cn.cat.domain.strategy.service.rule.chain;

public interface ILogicChainLink {
    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);
}
