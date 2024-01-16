package com.elkastali.geocoderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    @JsonProperty("results")
    private Results[] results;

}
