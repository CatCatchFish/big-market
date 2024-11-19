package cn.cat.test.domain.strategy;

import cn.cat.domain.strategy.service.armory.IStrategyArmory;
import cn.cat.domain.strategy.service.rule.chain.ILogicChain;
import cn.cat.domain.strategy.service.rule.chain.factory.DefaultLogicChainFactory;
import cn.cat.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogicChainTest {
    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;
    @Resource
    private DefaultLogicChainFactory defaultLogicChainFactory;

    @Test
    public void test_LogicChain_rule_blacklist() {
        ILogicChain logicChain = defaultLogicChainFactory.openLogicChain(100001L);
        DefaultLogicChainFactory.StrategyAwardVO strategyAwardVO = logicChain.logic("user001", 100001L);
        Integer awardId = strategyAwardVO.getAwardId();
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_weight() {
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4900L);
        ILogicChain logicChain = defaultLogicChainFactory.openLogicChain(100001L);
        DefaultLogicChainFactory.StrategyAwardVO strategyAwardVO = logicChain.logic("xiaofuge", 100001L);
        Integer awardId = strategyAwardVO.getAwardId();
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_default() {
        ILogicChain logicChain = defaultLogicChainFactory.openLogicChain(100003L);
        DefaultLogicChainFactory.StrategyAwardVO strategyAwardVO = logicChain.logic("xiaofuge", 100001L);
        Integer awardId = strategyAwardVO.getAwardId();
        log.info("测试结果：{}", awardId);
    }
}
