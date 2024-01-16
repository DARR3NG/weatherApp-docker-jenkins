package com.elkastali.geocoderservice.controller;


import com.elkastali.geocoderservice.dto.ResponseDto;
import com.elkastali.geocoderservice.model.Location;
import com.elkastali.geocoderservice.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController


public class GeocoderController {

    public static final String GEOCODEING_API = "AIzaSyA9l9LOLQEsjKAS2fnMHCZA6bvTZgb3jSI";

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }


        @GetMapping("/getLocation")
    public ResponseDto geoDetails(@RequestParam("address") String address) {
      UriComponents uri= UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("maps/api/geocode/json")
                .queryParam("address", address)
                .queryParam("key", GEOCODEING_API)
                .build();

        ResponseEntity<Response> response= new RestTemplate().getForEntity(uri.toUriString(), Response.class);

        return ResponseDto.builder()
            .lat(response.getBody().getResults()[0].getGeometry().getLocation().getLat())
            .lng(response.getBody().getResults()[0].getGeometry().getLocation().getLng())
            .address(response.getBody().getResults()[0].getAddress())
                .build();
    }
}
