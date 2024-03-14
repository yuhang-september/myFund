package com.yuhang.trading;

import com.yuhang.trading.common.RedisService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
@EnableSpringHttpSession
@MapperScan
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
