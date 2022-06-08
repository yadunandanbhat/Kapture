package com.kapture.springweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="weather-client-v1", url="http://api.openweathermap.org/")
interface OpenWeatherClientV1 {
    @RequestMapping(method = RequestMethod.GET, value = "data/2.5/weather?units=metric&zip={zip}&appid={apiKey}", consumes = "application/json")
    OpenWeatherApiResponseV1 getWeatherbyZip(@RequestParam("zip") String zip, @RequestParam("apiKey") String apiKey);
}

@RestController()
@RequestMapping("api/v1")
public class WeatherRestControllerV1 {

    @Value( "${open-weather-api-key}" )
    private String apiKey;


    private final OpenWeatherClientV1 weatherClient;

    public WeatherRestControllerV1(OpenWeatherClientV1 weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/weather")
    OpenWeatherApiResponseV1 getWeatherByZip(@RequestParam("zip") String zip) {
        OpenWeatherApiResponseV1 weatherApiResponse = weatherClient.getWeatherbyZip(zip, apiKey);
        return weatherApiResponse;
    }

}