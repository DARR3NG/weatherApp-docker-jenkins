package com.elkastali.weatherforecast.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private double lat;
    private double lng;
    private String address;
}
