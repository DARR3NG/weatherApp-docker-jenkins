package com.elkastali.weatherservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {

    @JsonProperty("coord")
    private Coordiante coordiante;
    private Weather[]   weather;
    private Main     main;
    private Wind wind;
}
