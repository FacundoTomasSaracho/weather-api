package com.facundosaracho.weatherapi.configuration;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

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
}
