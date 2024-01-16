package com.elkastali.weatherforecast.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class City {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public long sunrise;
    public long sunset;
}