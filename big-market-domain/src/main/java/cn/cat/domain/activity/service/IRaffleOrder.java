package cn.cat.domain.activity.service;

import cn.cat.domain.activity.model.entity.ActivityOrderEntity;
import cn.cat.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @description 抽奖活动订单接口
 */
public interface IRaffleOrder {
    /**
     * 创建抽奖活动订单
     *
     * @param activityShopCartEntity 活动sku实体，通过sku领取活动
     * @return 抽奖活动参与实体
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);
}
