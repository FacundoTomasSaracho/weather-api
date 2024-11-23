package com.facundosaracho.weatherapi.client.weather;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import retrofit2.Response;

public interface WeatherApiClientService {
    Response<WeatherApiResponse> getWeatherByCity(String apiKey, String city);
}