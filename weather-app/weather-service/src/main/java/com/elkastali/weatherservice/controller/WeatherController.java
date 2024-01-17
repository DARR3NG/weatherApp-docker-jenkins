package com.elkastali.weatherservice.controller;



import com.elkastali.weatherservice.model.Location;
import com.elkastali.weatherservice.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class WeatherController {

    @Value("${weather.api.key}")
    public   String API_KEY; //="e8bd6b4890c7fdc00af26251f764a9bf" ;

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }



/*
    @GetMapping("/weather/lat={lat}&lon={lon}")
    public Response getWeather(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        ResponseEntity<Response> response= new  RestTemplate().getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+ "&appid=" + API_KEY, Response.class);
    return response.getBody();
    }
*/


    @GetMapping("/weather")
    public Response getWeather(@RequestParam("address") String address){
        ResponseEntity<Location> response= new  RestTemplate().getForEntity("http://gateway-service:8888/GEOCODER-SERVICE/getLocation?address="+address, Location.class);



        Location location= response.getBody();
        ResponseEntity<Response> weather= new  RestTemplate().getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="+location.getLat()+"&lon="+location.getLng()+ "&appid=" + API_KEY+"&units=metric", Response.class);
         weather.getBody().getWeather()[0].setAddress(location.getAddress());
        return weather.getBody();


    }




}
