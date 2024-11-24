package cn.cat.domain.strategy.service.rule.tree.factory.engine.impl;

import cn.cat.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.cat.domain.strategy.model.valobj.RuleTreeNodeLineVO;
import cn.cat.domain.strategy.model.valobj.RuleTreeNodeVO;
import cn.cat.domain.strategy.model.valobj.RuleTreeVO;
import cn.cat.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.cat.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.cat.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 决策树引擎 组装树形结构
 */
@Slf4j
public class DecisionTreeEngine implements IDecisionTreeEngine {
    private final Map<String, ILogicTreeNode> loginTreeNodeMap;

    private final RuleTreeVO ruleTreeVO;

    public DecisionTreeEngine(Map<String, ILogicTreeNode> loginTreeNodeMap, RuleTreeVO ruleTreeVO) {
        this.loginTreeNodeMap = loginTreeNodeMap;
        this.ruleTreeVO = ruleTreeVO;
    }

    @Override
    public DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId, Date endDateTime) {
        DefaultTreeFactory.StrategyAwardVO strategyAwardVO = null;

        // 获取根节点
        String nextNode = ruleTreeVO.getTreeRootRuleNode();
        // 树状结构遍历
        Map<String, RuleTreeNodeVO> treeNodeMap = ruleTreeVO.getTreeNodeMap();

        RuleTreeNodeVO ruleTreeNode = treeNodeMap.get(nextNode);
        while (null != nextNode) {
            ILogicTreeNode logicTreeNode = loginTreeNodeMap.get(ruleTreeNode.getRuleKey());
            String ruleValue = ruleTreeNode.getRuleValue();
            // 决策逻辑
            DefaultTreeFactory.TreeActionEntity logicEntity = logicTreeNode.logic(userId, strategyId, awardId, ruleValue, endDateTime);
            RuleLogicCheckTypeVO ruleLogicCheckType = logicEntity.getRuleLogicCheckType();
            // 决策结果
            strategyAwardVO = logicEntity.getStrategyAwardVO();
            log.info("决策树引擎【{}】treeId:{} node:{} code:{}", ruleTreeVO.getTreeName(), ruleTreeVO.getTreeId(), nextNode, ruleLogicCheckType.getCode());


            nextNode = nextNode(ruleLogicCheckType.getCode(), ruleTreeNode.getTreeNodeLineVOList());
            ruleTreeNode = treeNodeMap.get(nextNode);
        }
        return strategyAwardVO;
    }

    public String nextNode(String matterValue, List<RuleTreeNodeLineVO> ruleTreeNodeLineVOList) {
        if (null == ruleTreeNodeLineVOList || ruleTreeNodeLineVOList.isEmpty()) return null;
        for (RuleTreeNodeLineVO nodeLine : ruleTreeNodeLineVOList) {
            if (decisionLogic(matterValue, nodeLine)) {
                return nodeLine.getRuleNodeTo();
            }
        }
        return null;
    }

    public boolean decisionLogic(String matterValue, RuleTreeNodeLineVO nodeLine) {
        switch (nodeLine.getRuleLimitType()) {
            case EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue().getCode());
            // 以下规则暂时不需要实现
            case GT:
            case LT:
            case GE:
            case LE:
            default:
                return false;
        }
    }
}