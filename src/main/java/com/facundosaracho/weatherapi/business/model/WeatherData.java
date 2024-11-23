package com.facundosaracho.weatherapi.business.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class WeatherData {

    private String city;
    private String weather;

}
