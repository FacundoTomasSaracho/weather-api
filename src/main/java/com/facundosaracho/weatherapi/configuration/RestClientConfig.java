package com.facundosaracho.weatherapi.configuration;

import com.facundosaracho.weatherapi.client.weather.configuration.WeatherApiRetrofitConfig;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
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

    public static <R> Response<R> handleRetrofitCalls(Call<R> call) {
        try {
            return call.execute();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
