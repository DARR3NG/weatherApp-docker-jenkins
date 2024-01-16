package com.elkastali.weatherforecast.model;


import lombok.*;

import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {
    public String cod;
    public int message;
    public int cnt;
    public List<ForecastItem> list;
    public City city;
}