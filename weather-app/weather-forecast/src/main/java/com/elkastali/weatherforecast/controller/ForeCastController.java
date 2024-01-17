package com.elkastali.weatherforecast.controller;


import com.elkastali.weatherforecast.model.Location;
import com.elkastali.weatherforecast.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class ForeCastController {

    //@Value("${weather.api.key}")
    public static  final String API_KEY ="e8bd6b4890c7fdc00af26251f764a9bf" ;






    @GetMapping("/weather")
    public WeatherForecast getWeather(@RequestParam("address") String address){
        ResponseEntity<Location> response= new RestTemplate().getForEntity("http://gateway-service:8888/GEOCODER-SERVICE/getLocation?address="+address, Location.class);



        Location location= response.getBody();
        ResponseEntity<WeatherForecast> weather= new  RestTemplate().getForEntity("https://api.openweathermap.org/data/2.5/forecast?lat="+location.getLat()+"&lon="+location.getLng() +"&appid="+API_KEY+"&units=metric&cnt=5", WeatherForecast.class);

        return weather.getBody();


    }
}
