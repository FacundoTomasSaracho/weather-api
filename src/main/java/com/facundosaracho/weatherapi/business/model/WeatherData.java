package com.facundosaracho.weatherapi.business.model;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class WeatherData {

    private String city;
    private String weather;

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

}
