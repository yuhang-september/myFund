package com.yuhang.trading.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuhang.service.entity.request.TradeRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author David
 * 2024-07-17 2:24 a.m.
 */
@Component
public class Sender {
    private final AmqpTemplate amqpTemplate;
    private final String exchange = "fund-trade-exchange";
    private final String routingKey1 = "trade.request.buy";
    private final String routingKey2 = "trade.request.redeem";

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendToBuyQueue(TradeRequest tradeRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(tradeRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        amqpTemplate.convertAndSend(exchange, routingKey1, jsonString);
        System.out.println("Sent message to queue1: " + jsonString);
    }

    public void sendToRedeemQueue(TradeRequest tradeRequest) {
        amqpTemplate.convertAndSend(exchange, routingKey2, tradeRequest);
        System.out.println("Sent message to queue2: " + tradeRequest);
    }

}
