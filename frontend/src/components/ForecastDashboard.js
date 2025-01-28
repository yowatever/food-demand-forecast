import React, { useState, useEffect } from 'react';
import { Line } from 'react-chartjs-2';
import axios from 'axios';

const ForecastDashboard = () => {
  const [forecastData, setForecastData] = useState([]);

  useEffect(() => {
    const fetchForecastData = async () => {
      try {
        const response = await axios.get('/api/forecasts');
        setForecastData(response.data);
      } catch (error) {
        console.error('Error fetching forecast data', error);
      }
    };

    fetchForecastData();
  }, []);

  const chartData = {
    labels: forecastData.map(item => item.forecastDate),
    datasets: [{
      label: 'Predicted Demand',
      data: forecastData.map(item => item.predictedDemand),
      borderColor: 'rgb(75, 192, 192)',
      tension: 0.1
    }]
  };

  return (
    <div>
      <h2>Food Delivery Demand Forecast</h2>
      <Line data={chartData} />
    </div>
  );
};

export default ForecastDashboard;
