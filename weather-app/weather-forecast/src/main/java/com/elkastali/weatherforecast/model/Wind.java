package com.elkastali.weatherforecast.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Wind {
    public double speed;
    public int deg;
    public double gust;
}

