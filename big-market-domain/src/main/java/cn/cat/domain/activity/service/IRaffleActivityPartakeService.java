package cn.cat.domain.activity.service;

import cn.cat.domain.activity.model.entity.PartakeRaffleActivityEntity;
import cn.cat.domain.activity.model.entity.UserRaffleOrderEntity;

public interface IRaffleActivityPartakeService {
    UserRaffleOrderEntity createOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);
}
