package cn.cat.domain.activity.service;

import cn.cat.domain.activity.model.entity.ActivityCountEntity;
import cn.cat.domain.activity.model.entity.ActivityEntity;
import cn.cat.domain.activity.model.entity.ActivitySkuEntity;
import cn.cat.domain.activity.repository.IActivityRepository;
import cn.cat.domain.activity.service.rule.factory.DefaultActivityChainFactory;

public class RaffleActivitySupport {
    protected IActivityRepository activityRepository;
    protected DefaultActivityChainFactory defaultActivityChainFactory;

    public RaffleActivitySupport(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory) {
        this.activityRepository = activityRepository;
        this.defaultActivityChainFactory = defaultActivityChainFactory;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }
}
