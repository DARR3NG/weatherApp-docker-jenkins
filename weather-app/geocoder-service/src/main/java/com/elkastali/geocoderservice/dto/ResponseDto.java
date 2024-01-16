


package com.elkastali.geocoderservice.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto {

    private double lat;
    private double lng;

    private String address;
}
