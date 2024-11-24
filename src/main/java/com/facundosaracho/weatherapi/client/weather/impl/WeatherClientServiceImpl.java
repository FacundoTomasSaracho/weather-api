package com.facundosaracho.weatherapi.client.weather.impl;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.client.weather.WeatherApiClientService;
import com.facundosaracho.weatherapi.client.weather.configuration.WeatherApiRetrofitConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import static com.facundosaracho.weatherapi.configuration.RestClientConfig.checkCall;
import static com.facundosaracho.weatherapi.configuration.RestClientConfig.validateResponse;

@Service
@AllArgsConstructor
public class WeatherClientServiceImpl implements WeatherApiClientService {

    private final WeatherApiRetrofitConfig weatherApiRetrofitConfig;

    @Override
    public WeatherApiResponse getWeatherByCity(String apiKey, String city) {
        Call<WeatherApiResponse> call = weatherApiRetrofitConfig.getWeatherByCity(apiKey, city);
        return validateResponse(checkCall(call)).body();
    }
}
