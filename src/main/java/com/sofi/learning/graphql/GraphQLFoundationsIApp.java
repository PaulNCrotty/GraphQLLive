package com.sofi.learning.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sofi.learning.graphql.config", "com.sofi.learning.graphql.resolver"})
public class GraphQLFoundationsIApp {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLFoundationsIApp.class, args);
    }
}
