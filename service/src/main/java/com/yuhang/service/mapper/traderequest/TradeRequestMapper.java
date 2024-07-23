package com.yuhang.service.mapper.traderequest;

import com.yuhang.service.entity.history.HistoryRequest;
import com.yuhang.service.entity.request.TradeRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeRequestMapper {

    void insert(@Param("request") TradeRequest request);
    List<TradeRequest> query(@Param("request") HistoryRequest request);
}
