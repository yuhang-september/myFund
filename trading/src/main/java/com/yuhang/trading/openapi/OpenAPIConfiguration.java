package com.yuhang.trading.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("The documentation is recording the MyFund Trading System.");

        Contact myContact = new Contact();
        myContact.setName("Yuhang Zhang (David)");
        myContact.setEmail("yuhang.september@gmail.com");

        Info information = new Info()
                .title("MyFund Trading System API")
                .version("1.0")
                .description("This API exposes endpoints to trade.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
