package cn.cat.test.infrastructure;

import cn.cat.infrastructure.persistent.dao.IRaffleActivityDao;
import cn.cat.infrastructure.persistent.po.RaffleActivity;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityTest {
    @Resource
    private IRaffleActivityDao raffleActivityDao;

    @Test
    public void test() {
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301L);
        log.info(JSON.toJSONString(raffleActivity));
    }
}
