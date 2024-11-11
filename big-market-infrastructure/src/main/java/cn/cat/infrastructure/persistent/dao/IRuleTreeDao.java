package cn.cat.infrastructure.persistent.dao;

import cn.cat.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRuleTreeDao {
    RuleTree queryRuleTreeByTreeId(String treeId);
}
