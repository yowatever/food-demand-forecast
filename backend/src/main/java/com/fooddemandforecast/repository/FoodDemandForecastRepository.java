package com.fooddemandforecast.repository;

import com.fooddemandforecast.model.FoodDemandForecast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDemandForecastRepository extends MongoRepository<FoodDemandForecast, String> {
    List<FoodDemandForecast> findByRestaurantId(String restaurantId);

    @Aggregation(pipeline = {
        "{$match: {restaurant_id: ?0}}",
        "{$group: {_id: '$forecast_date', total_demand: {$sum: '$predicted_demand'}}}"
    })
    List<AggregationResult> aggregateDemandByDate(String restaurantId);
}
