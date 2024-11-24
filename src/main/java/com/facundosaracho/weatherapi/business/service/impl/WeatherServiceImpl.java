package com.facundosaracho.weatherapi.business.service.impl;

import com.facundosaracho.weatherapi.business.model.WeatherData;
import com.facundosaracho.weatherapi.business.service.WeatherService;
import com.facundosaracho.weatherapi.client.weather.WeatherApiClientService;
import com.facundosaracho.weatherapi.configuration.mapper.WeatherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClientService weatherApiClientService;

    @Value("${apiKey}")
    private String apikey;

    @Override
    public WeatherData getWeatherInformation(String city) {
        return WeatherMapper.INSTANCE.toWeatherData(weatherApiClientService.getWeatherByCity(apikey, city));
    }

}
