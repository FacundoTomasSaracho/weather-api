package com.facundosaracho.weatherapi.business.service;

import com.facundosaracho.weatherapi.business.model.WeatherData;

public interface WeatherService {

    WeatherData getWeaterInformation() throws Exception;
}
