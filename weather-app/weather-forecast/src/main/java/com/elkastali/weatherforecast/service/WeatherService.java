package com.elkastali.weatherforecast.service;

import com.elkastali.weatherforecast.model.ForecastItem;
import com.elkastali.weatherforecast.model.WeatherForecast;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {


    public WeatherForecast extractTodayForecast(WeatherForecast completeForecast) {
        // Extract the current timestamp
        long currentTimestamp = Instant.now().getEpochSecond();

        // Iterate through the list of weather data to find entries for today
        for (ForecastItem data : completeForecast.getList()) {
            LocalDateTime forecastDateTime = LocalDateTime.ofEpochSecond(data.getDt(), 0, ZoneOffset.UTC);

            // Check if the forecast date is today
            if (forecastDateTime.toLocalDate().isEqual(LocalDateTime.ofEpochSecond(currentTimestamp, 0, ZoneOffset.UTC).toLocalDate())) {
                // Create a new WeatherForecast object for today
                WeatherForecast todayForecast = new WeatherForecast();
                todayForecast.setList(List.of(data));
                return todayForecast;
            }
        }
        // If no forecast data for today is found, return an empty forecast
        return new WeatherForecast();
    }



    public List<WeatherForecast> extractFutureForecast(WeatherForecast completeForecast) {
        // Extract the current timestamp
        long currentTimestamp = Instant.now().getEpochSecond();

        // Create a list to store future forecast data
        List<ForecastItem> futureForecastData = new ArrayList<>();

        // Iterate through the list of weather data to find entries for future dates
        for (ForecastItem data : completeForecast.getList()) {
            LocalDateTime forecastDateTime = LocalDateTime.ofEpochSecond(data.getDt(), 0, ZoneOffset.UTC);

            // Check if the forecast date is after today
            if (forecastDateTime.isAfter(LocalDateTime.ofEpochSecond(currentTimestamp, 0, ZoneOffset.UTC))) {
                futureForecastData.add(data);
            }
        }

        // Create a new WeatherForecast object for the future forecast
        WeatherForecast futureForecast = new WeatherForecast();
        futureForecast.setList(futureForecastData);

        return List.of(futureForecast);
    }
}
