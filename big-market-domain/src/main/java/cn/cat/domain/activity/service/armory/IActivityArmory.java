package cn.cat.domain.activity.service.armory;

public interface IActivityArmory {
    boolean assembleActivitySku(Long sku);

    boolean assembleActivitySkuByActivityId(Long activityId);
}