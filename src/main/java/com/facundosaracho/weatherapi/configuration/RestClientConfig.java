package com.facundosaracho.weatherapi.configuration;

import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.client.weather.configuration.WeatherApiRetrofitConfig;
import com.facundosaracho.weatherapi.exception.RestException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facundosaracho.weatherapi.exception.ErrorDetails.RETROFIT_ERROR;
import static com.facundosaracho.weatherapi.exception.ErrorDetails.WEATHER_NOT_FOUND;

@Configuration
@Slf4j
public class RestClientConfig {

    @Value("${weatherApiUrl}")
    private String weatherApiUrl;

    @Bean
    Retrofit retrofit() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return new Retrofit
                .Builder()
                .baseUrl(weatherApiUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Bean
    public WeatherApiRetrofitConfig weatherApiRetrofitConfig(Retrofit retrofit) {
        return retrofit.create(WeatherApiRetrofitConfig.class);
    }

    public static Response<WeatherApiResponse> validateResponse(Response<WeatherApiResponse> responseResponse) {
        if (responseResponse == null || !responseResponse.isSuccessful()) {
            throw new RestException(WEATHER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return responseResponse;
    }

    public static <R> Response<R> checkCall(Call<R> call) {
        try {
            return call.execute();
        } catch (Exception e) {
            log.error("ERROR :{} ", e.getMessage());
            throw new RestException(RETROFIT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
