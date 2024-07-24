package com.yuhang.trading.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuhang.service.entity.request.TradeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author David
 * 2024-07-17 2:24 a.m.
 */
@Component
@Slf4j
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
        String jsonString = getJsonString(tradeRequest);
        log.debug("[sendToBuyQueue]: {}]", jsonString);
        amqpTemplate.convertSendAndReceive(exchange, routingKey1, jsonString);
    }

    public void sendToRedeemQueue(TradeRequest tradeRequest) {
        String jsonString = getJsonString(tradeRequest);
        log.debug("[sendToRedeemQueue]: {}]", jsonString);
        amqpTemplate.convertSendAndReceive(exchange, routingKey2, jsonString);
    }

    private String getJsonString(TradeRequest request) {
        String jsonString;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }
}
