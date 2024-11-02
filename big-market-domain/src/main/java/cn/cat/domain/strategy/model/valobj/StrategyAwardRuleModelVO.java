package cn.cat.domain.strategy.model.valobj;

import cn.cat.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import cn.cat.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

    public String[] raffleCenterRuleModelList() {
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        return Arrays.stream(ruleModelValues)
                .filter(DefaultLogicFactory.LogicModel::isCenter).toArray(String[]::new);
    }

    public String[] raffleAfterRuleModelList() {
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        return Arrays.stream(ruleModelValues)
                .filter(DefaultLogicFactory.LogicModel::isAfter).toArray(String[]::new);
    }
}
