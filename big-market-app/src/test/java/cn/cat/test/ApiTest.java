package cn.cat.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Test
    public void test() {
        Map<Long, String> analyticalValueGroup = new HashMap<>();
        analyticalValueGroup.put(10L, "Value1");
        analyticalValueGroup.put(20L, "Value2");
        analyticalValueGroup.put(30L, "Value3");

        Long targetValue = 15L;

        // 使用 Stream 筛选并找出大于 targetValue 的最小值
        Optional<Long> minValue = analyticalValueGroup.keySet().stream()
                .filter(key -> key <= targetValue)         // 过滤出大于 targetValue 的值
                .min(Long::compare);                      // 找出最小的符合条件的值

        minValue.ifPresent(aLong -> log.info("The minimum value greater than {} is {}", targetValue, aLong));
    }

}
