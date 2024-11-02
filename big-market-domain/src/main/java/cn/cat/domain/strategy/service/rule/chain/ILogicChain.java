package cn.cat.domain.strategy.service.rule.chain;

public interface ILogicChain extends ILogicChainLink {
    Integer logic(String userId, Long strategyId);
}
