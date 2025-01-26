package com.fooddemandforecast.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "food_demand_forecasts")
public class FoodDemandForecast {
    @Id
    private String id;

    @Field("restaurant_id")
    private String restaurantId;

    @Field("forecast_date")
    private LocalDate forecastDate;

    @Field("predicted_demand")
    private Double predictedDemand;

    @Field("confidence_score")
    private Double confidenceScore;
}
