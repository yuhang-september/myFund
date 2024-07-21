package com.yuhang.rabbitmq;

import org.springframework.stereotype.Component;

/**
 * @author David
 * 2024-07-17 2:53 a.m.
 */
@Component
public class RedeemReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
