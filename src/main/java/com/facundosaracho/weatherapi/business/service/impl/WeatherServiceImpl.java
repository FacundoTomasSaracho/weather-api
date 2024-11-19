package com.facundosaracho.weatherapi.business.service.impl;

import com.facundosaracho.weatherapi.business.model.WeatherData;
import com.facundosaracho.weatherapi.business.model.client.WeatherApiResponse;
import com.facundosaracho.weatherapi.business.service.WeatherService;
import com.facundosaracho.weatherapi.configuration.WeatherApiRetrofitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiRetrofitConfig weatherApi;

    @Value("${apiKey}")
    private String apikey;


    @Override
    public WeatherData getWeaterInformation() throws Exception {
        try {
            Response<WeatherApiResponse> response = weatherApi.getWeatherByCity(apikey, "Madrid").execute();
            WeatherApiResponse weatherApiResponse = response.body();
            WeatherApiResponse.Condition condition = weatherApiResponse.getCurrent().getCondition();
            WeatherApiResponse.Location location = weatherApiResponse.getLocation();
            if (response.isSuccessful()) {
                return new WeatherData(location.getName(), condition.getText());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
