package com.yuhang.rabbitmq;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RabbitmqApplication {

    static final String topicExchangeName = "fund-trade-exchange";

    static final String buyQueue = "buy-trade-queue";
    static final String redeemQueue = "redeem-trade-queue";

    @Bean
    Queue buyQueue() {
        return new Queue(buyQueue, false);
    }

    @Bean
    Queue redeemQueue() {
        return new Queue(redeemQueue, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding buyBinding(Queue buyQueue, TopicExchange exchange) {
        return BindingBuilder.bind(buyQueue).to(exchange).with("trade.request.buy");
    }

    @Bean
    Binding redeemBinding(Queue redeemQueue, TopicExchange exchange) {
        return BindingBuilder.bind(redeemQueue).to(exchange).with("trade.request.redeem");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(new DefaultBaseTypeLimitingValidator(), ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.PROPERTY);

        return new Jackson2JsonMessageConverter(objectMapper);
    }


    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
