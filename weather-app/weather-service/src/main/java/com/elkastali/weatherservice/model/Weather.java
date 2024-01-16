package com.elkastali.weatherservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weather {

    private long   id;
    private String description;
    private String icon;
    private String address;
}
