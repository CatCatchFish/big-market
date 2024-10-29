package cn.cat.test.domain;

import cn.cat.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StrategyArmoryTest {
    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void armoryTest() {
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void getAssembleLotteryTest() {
        for (int i = 0; i < 100; i++) {
            log.info("抽奖结果：{}，奖品ID", strategyArmory.getRandomAwardId(100002L));
        }
    }
}
