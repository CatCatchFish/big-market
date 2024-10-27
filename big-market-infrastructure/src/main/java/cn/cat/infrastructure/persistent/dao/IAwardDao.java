package cn.cat.infrastructure.persistent.dao;

import cn.cat.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Cat
 * @description 奖品Dao接口
 */
@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();
}
