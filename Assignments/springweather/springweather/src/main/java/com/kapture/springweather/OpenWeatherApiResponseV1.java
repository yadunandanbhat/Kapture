package com.kapture.springweather;

import lombok.Data;
import java.util.List;

@Data
class WeatherInfoV1 {
    private String main;
    private String description;
}

@Data
class MainV1 {
    private Number temp;
    private Number feels_like;
}

@Data
public class OpenWeatherApiResponseV1 {
    private List<WeatherInfo> weather;
    private Main main;
}