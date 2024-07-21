package com.yuhang.trading.history;

import com.yuhang.service.entity.history.HistoryRequest;
import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.trading.mapper.traderequest.TradeRequestMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 * 2024-06-13 1:06 a.m.
 */
@Service
public class HistoryService {

    @Resource
    private TradeRequestMapper tradeRequestMapper;

    public List<TradeRequest> getHistory(HistoryRequest historyRequest) {
        return new ArrayList<>(tradeRequestMapper.query(historyRequest));
    }
}
