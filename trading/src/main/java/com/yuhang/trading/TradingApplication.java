package com.yuhang.trading;

import com.yuhang.service.common.RedisService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableSpringHttpSession
@MapperScan("com.yuhang.service.mapper")
@ComponentScan(basePackages = "com.yuhang")
public class TradingApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TradingApplication.class, args);
        redisInitial(context);
    }

    private static void redisInitial(ApplicationContext context) {
        RedisService redisService = context.getBean(RedisService.class);
        redisService.initial();
    }

}
