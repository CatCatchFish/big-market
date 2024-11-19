package cn.cat.domain.activity.service.rule.impl;

import cn.cat.domain.activity.model.entity.ActivityCountEntity;
import cn.cat.domain.activity.model.entity.ActivityEntity;
import cn.cat.domain.activity.model.entity.ActivitySkuEntity;
import cn.cat.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 活动规则过滤 [时间、状态]
 */
@Slf4j
@Component("activity_base_action")
public class ActivityBaseActionChain extends AbstractActionChain {
    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        return true;
    }
}
