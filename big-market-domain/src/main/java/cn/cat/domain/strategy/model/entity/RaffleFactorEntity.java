package cn.cat.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 抽奖策略因子实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaffleFactorEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 奖品ID
     */
    private Integer awardId;
    /**
     * 结束时间
     */
    private Date endDateTime;
}
