package com.facundosaracho.weatherapi.client.weather.configuration;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiRetrofitConfig {

    @GET("current.json")
    Call<WeatherApiResponse> getWeatherByCity(
            @Query("key") String key,
            @Query("q") String city);

}
