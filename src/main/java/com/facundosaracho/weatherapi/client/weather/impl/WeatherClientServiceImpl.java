package com.facundosaracho.weatherapi.client.weather.impl;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.client.weather.WeatherApiClientService;
import com.facundosaracho.weatherapi.client.weather.configuration.WeatherApiRetrofitConfig;
import com.facundosaracho.weatherapi.exception.ErrorDetails;
import com.facundosaracho.weatherapi.exception.RestException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import static com.facundosaracho.weatherapi.configuration.RestClientConfig.handleRetrofitCalls;

@Service
@AllArgsConstructor
public class WeatherClientServiceImpl implements WeatherApiClientService {

    private final WeatherApiRetrofitConfig weatherApiRetrofitConfig;

    @Override
    public Response<WeatherApiResponse> getWeatherByCity(String apiKey, String city) {
        Call<WeatherApiResponse> call = weatherApiRetrofitConfig.getWeatherByCity(apiKey, city);
        Response<WeatherApiResponse> response = handleRetrofitCalls(call);
        validateResponse(response);
        return response;
    }

    private void validateResponse(Response<WeatherApiResponse> responseResponse) {
        if (responseResponse == null || !responseResponse.isSuccessful())
            throw new RestException(ErrorDetails.WEATHER_NOT_FOUND.getCode(),
                    ErrorDetails.WEATHER_NOT_FOUND.getMessage(),
                    HttpStatus.NOT_FOUND);
    }
}
