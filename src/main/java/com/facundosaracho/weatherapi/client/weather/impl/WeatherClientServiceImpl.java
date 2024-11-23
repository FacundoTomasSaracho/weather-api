package com.facundosaracho.weatherapi.client.weather.impl;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.client.weather.WeatherApiClientService;
import com.facundosaracho.weatherapi.client.weather.configuration.WeatherApiRetrofitConfig;
import com.facundosaracho.weatherapi.exception.ClientException;
import com.facundosaracho.weatherapi.exception.ErrorDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

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

    private void validateResponse(Response<WeatherApiResponse> responseResponse) throws ClientException {
        if (responseResponse == null || !responseResponse.isSuccessful())
            throw new ClientException(ErrorDetails.WEATHER_NOT_FOUND.getCode(),
                    ErrorDetails.WEATHER_NOT_FOUND.getMessage(),
                    HttpStatus.NOT_FOUND);
    }

    private <R> Response<R> handleRetrofitCalls(Call<R> call) {
        try {
            return call.execute();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
