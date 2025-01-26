package com.fooddemandforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FoodDemandForecastApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodDemandForecastApplication.class, args);
    }
}
