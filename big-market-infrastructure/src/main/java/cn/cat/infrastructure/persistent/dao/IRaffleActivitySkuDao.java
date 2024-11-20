package cn.cat.infrastructure.persistent.dao;

import cn.cat.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRaffleActivitySkuDao {
    RaffleActivitySku queryActivitySku(Long sku);

    void clearActivitySkuStock(Long sku);

    void updateActivitySkuStock(Long sku);
}
