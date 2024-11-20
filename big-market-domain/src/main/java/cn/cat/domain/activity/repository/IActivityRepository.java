package cn.cat.domain.activity.repository;

import cn.cat.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.cat.domain.activity.model.entity.ActivityCountEntity;
import cn.cat.domain.activity.model.entity.ActivityEntity;
import cn.cat.domain.activity.model.entity.ActivitySkuEntity;
import cn.cat.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;

/**
 * @description 活动仓储接口
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    CreateOrderAggregate buildOrderAggregate(Long sku);

    void doSaveOrder(CreateOrderAggregate orderAggregate);

    void cacheActivitySkuStockCount(String key, Integer stockCount);

    boolean subtractionActivitySkuStock(Long sku, String key, Date endDateTime);

    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);

    void clearQueueValue();

    void clearActivitySkuStock(Long sku);

    ActivitySkuStockKeyVO takeQueueValue();

    void updateActivitySkuStock(Long sku);
}
