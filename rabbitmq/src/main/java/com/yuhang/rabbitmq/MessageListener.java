package com.yuhang.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author David
 * 2024-07-21 2:45 a.m.
 */
@Service
public class MessageListener {

    @RabbitListener(queues = "buy-trade-queue")
    public void handleBuyMessage(String message) {
        System.out.println("Received buy message: " + message);
    }

    @RabbitListener(queues = "redeem-trade-queue")
    public void handleRedeemMessage(String message) {
        System.out.println("Received redeem message: " + message);
    }
}

