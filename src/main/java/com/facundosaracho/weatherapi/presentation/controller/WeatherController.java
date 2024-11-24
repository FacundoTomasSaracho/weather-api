package com.facundosaracho.weatherapi.presentation.controller;

import com.facundosaracho.weatherapi.business.service.WeatherService;
import com.facundosaracho.weatherapi.configuration.mapper.WeatherMapper;
import com.facundosaracho.weatherapi.presentation.dto.WeatherDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("climate")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("{city}")
    ResponseEntity<WeatherDataDto> getWeatherInformation(@PathVariable String city) {
        return new ResponseEntity<>(WeatherMapper.INSTANCE.toWeatherDto(weatherService.getWeatherInformation(city)), HttpStatus.OK);
    }
}

