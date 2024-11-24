package cn.cat.trigger.api.dto;

import lombok.Data;

/**
 * @description 活动抽奖请求对象
 */
@Data
public class ActivityDrawRequestDTO {

    /**
     * 用户ID
     */
    private String userId;
    // 后续需要 userToken 作为Rpc调用凭证

    /**
     * 活动ID
     */
    private Long activityId;

}
