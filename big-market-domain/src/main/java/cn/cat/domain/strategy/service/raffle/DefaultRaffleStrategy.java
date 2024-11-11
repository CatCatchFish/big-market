package cn.cat.domain.strategy.service.raffle;

import cn.cat.domain.strategy.model.valobj.RuleTreeVO;
import cn.cat.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.cat.domain.strategy.service.AbstractRaffleStrategy;
import cn.cat.domain.strategy.repository.IStrategyRepository;
import cn.cat.domain.strategy.service.armory.IStrategyDispatch;
import cn.cat.domain.strategy.service.rule.chain.ILogicChain;
import cn.cat.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.cat.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.cat.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultRaffleStrategy extends AbstractRaffleStrategy {

    public DefaultRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory) {
        super(repository, strategyDispatch, defaultChainFactory, defaultTreeFactory);
    }

    /**
     * 抽奖策略逻辑链
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return strategyAwardVO 奖品ID 抽奖策略
     */
    @Override
    public DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId) {
        ILogicChain iLogicChain = defaultChainFactory.openLogicChain(strategyId);
        return iLogicChain.logic(userId, strategyId);
    }

    /**
     * 抽奖规则决策树
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return strategyAwardVO 奖品ID 抽奖规则
     */
    @Override
    public DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId) {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(strategyId, awardId);
        if (null == strategyAwardRuleModelVO) {
            // 没有为该策略下的奖品做限制，直接返回奖品ID
            return DefaultTreeFactory.StrategyAwardVO.builder().awardId(awardId).build();
        }

        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId(strategyAwardRuleModelVO.getRuleModels());
        if (null == ruleTreeVO) {
            throw new RuntimeException("存在抽奖策略配置的规则模型 Key，未在库表 rule_tree、rule_tree_node、rule_tree_line 配置对应的规则树信息 " + strategyAwardRuleModelVO.getRuleModels());
        }
        IDecisionTreeEngine treeEngine = defaultTreeFactory.openLogicTree(ruleTreeVO);
        return treeEngine.process(userId, strategyId, awardId);

    }
}
