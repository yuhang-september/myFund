package com.yuhang.rabbitmq;

import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.service.mapper.traderequest.TradeRequestMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author David
 * 2024-07-17 2:36 a.m.
 */
@Component
public class BuyReceiver {

    @Resource
    TradeRequestMapper tradeRequestMapper;

    public void receiveMessage(TradeRequest tradeRequest) {
        tradeRequestMapper.insert(tradeRequest);
    }
}
