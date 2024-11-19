package cn.cat.domain.activity.repository;

import cn.cat.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.cat.domain.activity.model.entity.ActivityCountEntity;
import cn.cat.domain.activity.model.entity.ActivityEntity;
import cn.cat.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @description 活动仓储接口
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    CreateOrderAggregate buildOrderAggregate(Long sku);

    void doSaveOrder(CreateOrderAggregate orderAggregate);

}
