package cn.cat.domain.activity.repository;

import cn.cat.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import cn.cat.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import cn.cat.domain.activity.model.entity.*;
import cn.cat.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;
import java.util.List;

/**
 * @description 活动仓储接口
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    CreateQuotaOrderAggregate buildOrderAggregate(Long sku);

    void doSaveOrder(CreateQuotaOrderAggregate orderAggregate);

    void cacheActivitySkuStockCount(String key, Integer stockCount);

    boolean subtractionActivitySkuStock(Long sku, String key, Date endDateTime);

    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);

    void clearQueueValue();

    void clearActivitySkuStock(Long sku);

    ActivitySkuStockKeyVO takeQueueValue();

    void updateActivitySkuStock(Long sku);

    UserRaffleOrderEntity queryNoUsedRaffleOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);

    ActivityAccountEntity queryActivityAccountByUserId(String userId, Long activityId);

    ActivityAccountMonthEntity queryActivityAccountMonthByUserId(String userId, Long activityId, String month);

    ActivityAccountDayEntity queryActivityAccountDayByUserId(String userId, Long activityId, String day);

    void saveCreatePartakeOrderAggregate(CreatePartakeOrderAggregate createPartakeOrderAggregate);

    List<ActivitySkuEntity> queryActivitySkuListByActivityId(Long activityId);

    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);
}
