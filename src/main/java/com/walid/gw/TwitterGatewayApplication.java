package com.walid.gw;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wmoustafa
 */
@SpringBootApplication
@EnableOpenApi
public class TwitterGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterGatewayApplication.class, args);
    }

    @Bean
    public Docket api() {
        // @formatter:off
        return new Docket(DocumentationType.OAS_30)
            .select()
            .apis(basePackage("com.walid.gw.controller"))
            .paths(PathSelectors.any())
            .build();
        // @formatter:off
    }
}
