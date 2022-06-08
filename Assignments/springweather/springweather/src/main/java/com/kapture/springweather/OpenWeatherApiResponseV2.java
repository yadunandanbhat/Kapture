package com.kapture.springweather;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
class WeatherInfo {
    private String main;
    private String description;
}

@Data
class Main {
    private Number temp;
    private Number feels_like;
    private Number pressure;
    private Number humidity;
}

class Sys {
    private Long sunrise;
    private Long sunset;

    public String getSunrise() {
        Date date = new Date(sunrise*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        return sdf.format(date);
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        Date date = new Date(sunset*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        return sdf.format(date);
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}

@Data
public class OpenWeatherApiResponseV2 {
    private List<WeatherInfo> weather;
    private Main main;
    private Sys sys;
}