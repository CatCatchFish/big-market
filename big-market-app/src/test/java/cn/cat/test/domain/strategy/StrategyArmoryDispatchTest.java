package cn.cat.test.domain.strategy;

import cn.cat.domain.strategy.service.armory.IStrategyArmory;
import cn.cat.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StrategyArmoryDispatchTest {
    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IStrategyDispatch strategyDispatch;

    @Before
    public void armoryTest() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        if (success) {
            log.info("策略组装成功");
        }
    }

    @Test
    public void getAssembleLotteryTest() {
        for (int i = 0; i < 20; i++) {
            log.info("抽奖结果：{}，奖品ID", strategyDispatch.getRandomAwardId(100001L));
        }
    }

    @Test
    public void test_getRandomAwardId_ruleWeightValue() {
        for (int i = 0; i < 20; i++) {
            log.info("抽奖结果：{}，奖品ID", strategyDispatch.getRandomAwardId(100001L, "4000"));
        }
    }
}
