package cn.cat.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @description 抽奖活动账户表-每日次数
 */
@Data
public class RaffleActivityAccountDay {

    /**
     * 自增ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 月（yyyy-mm）
     */
    private String day;
    /**
     * 月次数
     */
    private Integer dayCount;
    /**
     * 月次数-剩余
     */
    private Integer dayCountSurplus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
