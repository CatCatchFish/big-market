package cn.cat.infrastructure.persistent.dao;

import cn.cat.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);
}
