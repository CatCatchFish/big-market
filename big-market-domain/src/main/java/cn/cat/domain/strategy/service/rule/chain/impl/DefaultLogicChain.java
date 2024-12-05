package cn.cat.domain.strategy.service.rule.chain.impl;

import cn.cat.domain.strategy.service.armory.IStrategyDispatch;
import cn.cat.domain.strategy.service.rule.chain.AbstractLogicChain;
import cn.cat.domain.strategy.service.rule.chain.factory.DefaultLogicChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component("rule_default")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DefaultLogicChain extends AbstractLogicChain {
    @Resource
    protected IStrategyDispatch strategyDispatch;

    @Override
    public DefaultLogicChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
        return DefaultLogicChainFactory.StrategyAwardVO.builder()
                .awardId(awardId)
                .logicModel(ruleModel())
                .build();
    }

    @Override
    protected String ruleModel() {
        return DefaultLogicChainFactory.LogicModel.RULE_DEFAULT.getCode();
    }
}
