package com.example.mongodbconfigurationwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.mongodbconfigurationwithspringboot.repository")
public class MongoDbConfigurationWithSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbConfigurationWithSpringbootApplication.class, args);
    }

}
