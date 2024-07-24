package com.yuhang.service.mapper.tradebusiness;

import com.yuhang.service.entity.request.TradeBusiness;
import org.apache.ibatis.annotations.Param;

public interface TradeBusinessMapper {

    void insert(@Param("business") TradeBusiness business);
}
