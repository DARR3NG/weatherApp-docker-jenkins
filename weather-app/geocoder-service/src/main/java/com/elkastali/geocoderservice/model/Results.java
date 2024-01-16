package com.elkastali.geocoderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Results {
    @JsonProperty("formatted_address")
    private String address;
    @JsonProperty("geometry")
    private Geometry geometry;

}
