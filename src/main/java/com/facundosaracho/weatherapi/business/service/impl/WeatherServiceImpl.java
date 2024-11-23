package com.facundosaracho.weatherapi.business.service.impl;

import com.facundosaracho.weatherapi.business.model.WeatherData;
import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.business.service.WeatherService;
import com.facundosaracho.weatherapi.client.weather.WeatherApiClientService;
import com.facundosaracho.weatherapi.exception.BusinessException;
import com.facundosaracho.weatherapi.exception.ClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClientService weatherApiClientService;

    @Value("${apiKey}")
    private String apikey;

    @Override
    public WeatherData getWeaterInformation() throws BusinessException {

        try {
            Response<WeatherApiResponse> response = weatherApiClientService.getWeatherByCity(apikey, "Madrid");
            WeatherApiResponse weatherApiResponse = response.body();
            WeatherApiResponse.Condition condition = weatherApiResponse.getCurrent().getCondition();
            WeatherApiResponse.Location location = weatherApiResponse.getLocation();
            return new WeatherData(condition.getText(), location.getCountry());
        } catch (ClientException e) {
            throw new BusinessException(e.getCode(), e.getMessage(), e.getHttpStatusCode());
        }
    }

}
