package com.facundosaracho.weatherapi.business.service;

import com.facundosaracho.weatherapi.business.model.WeatherData;

import java.io.IOException;

public interface WeatherService {

    WeatherData getWeaterInformation() throws BusinessException, IOException;
}
