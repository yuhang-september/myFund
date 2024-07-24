package com.yuhang.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuhang.service.common.RuleException;
import com.yuhang.service.entity.request.TradeRequest;
import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author David
 * 2024-07-21 2:45 a.m.
 */
@Service
public class MessageListener {

    ObjectMapper mapper = new ObjectMapper();

    @Resource
    BuyReceiver buyReceiver;
    @Resource
    RedeemReceiver redeemReceiver;

    @RabbitListener(queues = "buy-trade-queue")
    public void handleBuyMessage(String message) throws JsonProcessingException {
        buyReceiver.receiveMessage(mapper.readValue(message, TradeRequest.class));
    }

    @RabbitListener(queues = "redeem-trade-queue")
    public void handleRedeemMessage(String message) throws RuleException, JsonProcessingException {
        redeemReceiver.receiveMessage(mapper.readValue(message, TradeRequest.class));
    }
}

