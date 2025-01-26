package com.fooddemandforecast.repository;

import lombok.Data;

@Data
public class AggregationResult {
    private String forecastDate;
    private Double totalDemand;
}
