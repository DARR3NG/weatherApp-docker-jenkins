package com.elkastali.weatherforecast.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}