package com.facundosaracho.weatherapi.business.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;




public class WeatherData {

    public WeatherData(String city, String weather){
        this.weather = weather;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @JsonProperty("city")
    private String city;
    @JsonProperty("weather")
    private String weather;

}
