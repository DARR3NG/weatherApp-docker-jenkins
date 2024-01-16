package com.elkastali.weatherservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int    pressure;
    private int    humidity;

}
