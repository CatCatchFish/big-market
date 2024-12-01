package cn.cat.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperTest {
    @Resource
    private CuratorFramework curatorFramework;

    /**
     * 创建永久节点
     */
    @Test
    public void createNode() throws Exception {
        String path = "/big-market-dcc/config/downgradeSwitch/test/a";
        String data = "0";
        if (null == curatorFramework.checkExists().forPath(path)) {
            curatorFramework.create().creatingParentsIfNeeded().forPath(path);
        }
    }

    /**
     * 往节点种设置数据
     */
    @Test
    public void setData() throws Exception {
        curatorFramework.setData().forPath("/big-market-dcc/config/downgradeSwitch", "111".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void getData() throws Exception {
        String downgradeSwitch = new String(curatorFramework.getData().forPath("/big-market-dcc/config/downgradeSwitch"), StandardCharsets.UTF_8);
        log.info("测试结果: {}", downgradeSwitch);
    }

    @Test
    public void test_all() throws Exception {
        String path = "/big-market-dcc/config/downgradeSwitch";
        String data = "0";
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(path, data.getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < 2; i++) {
            curatorFramework.setData().forPath(path, String.valueOf(i).getBytes(StandardCharsets.UTF_8));
        }
    }


    /**
     * 删除节点
     */
    @Test
    public void deleteData() throws Exception {
        String path = "/big-market-dcc/config/degradeSwitch";
        curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);
    }

}
