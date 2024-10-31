package cn.cat.domain.strategy.service.raffle;

import cn.cat.domain.strategy.model.entity.RaffleAwardEntity;
import cn.cat.domain.strategy.model.entity.RaffleFactorEntity;
import cn.cat.domain.strategy.model.entity.RuleActionEntity;
import cn.cat.domain.strategy.model.entity.StrategyEntity;
import cn.cat.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.cat.domain.strategy.repository.IStrategyRepository;
import cn.cat.domain.strategy.service.IRaffleStrategy;
import cn.cat.domain.strategy.service.armory.IStrategyDispatch;
import cn.cat.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.cat.types.enums.ResponseCode;
import cn.cat.types.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@AllArgsConstructor
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {
    protected IStrategyRepository repository;
    protected IStrategyDispatch strategyDispatch;

    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        if (null == strategyId || StringUtils.isBlank(userId)) {
            log.error("strategyId or userId is null or empty");
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2. 策略查询
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);

        // 3. 抽奖前 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> ruleActionEntity =
                this.doCheckRaffleBeforeLogic(RaffleFactorEntity.builder()
                        .userId(userId)
                        .strategyId(strategyId)
                        .build(), strategy.ruleModels());

        // 4. 规则引擎掌管
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionEntity.getCode())) {
            Integer awardId = null;
            if (DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 黑名单返回固定的奖品ID
                awardId = ruleActionEntity.getData().getAwardId();
            } else if (DefaultLogicFactory.LogicModel.RULE_WIGHT.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 权重根据返回的信息进行抽奖
                RuleActionEntity.RaffleBeforeEntity raffleBeforeEntity = ruleActionEntity.getData();
                String ruleWeightValueKey = raffleBeforeEntity.getRuleWeightValueKey();
                awardId = strategyDispatch.getRandomAwardId(strategyId, ruleWeightValueKey);
            }
            return RaffleAwardEntity.builder()
                    .awardId(awardId)
                    .build();
        }

        // 5. 默认抽奖流程
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build();
    }

    protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic
            (RaffleFactorEntity raffleFactorEntity, String... logics);
}
