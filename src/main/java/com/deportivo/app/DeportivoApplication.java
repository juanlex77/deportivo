package com.deportivo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.deportivo.app.repository")
public class DeportivoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeportivoApplication.class, args);
    }
}