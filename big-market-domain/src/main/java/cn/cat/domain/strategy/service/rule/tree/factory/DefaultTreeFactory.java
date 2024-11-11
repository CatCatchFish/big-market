package cn.cat.domain.strategy.service.rule.tree.factory;

import cn.cat.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.cat.domain.strategy.model.valobj.RuleTreeVO;
import cn.cat.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.cat.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import cn.cat.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultTreeFactory {
    private final Map<String, ILogicTreeNode> loginTreeNodeMap;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> loginTreeNodeMap) {
        this.loginTreeNodeMap = loginTreeNodeMap;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        // 装配决策树
        return new DecisionTreeEngine(loginTreeNodeMap, ruleTreeVO);
    }

    /**
     * 决策树个动作实习
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        /**
         * 奖品ID 内部流转使用
         */
        private Integer awardId;
        /**
         * 抽奖奖品对应的规则值
         */
        private String awardRuleValue;
    }
}
