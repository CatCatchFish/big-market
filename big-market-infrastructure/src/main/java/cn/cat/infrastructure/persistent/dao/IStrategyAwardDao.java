package cn.cat.infrastructure.persistent.dao;

import cn.cat.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Cat
 * @description 抽奖策略奖品明细配置dao
 */
@Mapper
public interface IStrategyAwardDao {
    List<StrategyAward> queryStrategyAwardList();
}
