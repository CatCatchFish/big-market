package cn.cat.domain.strategy.service.rule;

import cn.cat.domain.strategy.model.entity.RuleActionEntity;
import cn.cat.domain.strategy.model.entity.RuleMatterEntity;

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}
