package com.simple.api_web.docapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {

    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI().info(
                new Info().description("API Web Credito Rapido - opera com FGTS")
                        .version("1.0.0")
                        .title("Credito Rapido")
        );
    }
}