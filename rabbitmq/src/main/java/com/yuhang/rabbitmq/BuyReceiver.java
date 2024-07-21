package com.yuhang.rabbitmq;

import com.yuhang.service.entity.request.TradeRequest;
import org.springframework.stereotype.Component;

/**
 * @author David
 * 2024-07-17 2:36 a.m.
 */
@Component
public class BuyReceiver {
    public void receiveMessage(TradeRequest tradeRequest) {
        System.out.println("Received <" + tradeRequest + ">");
    }
}
