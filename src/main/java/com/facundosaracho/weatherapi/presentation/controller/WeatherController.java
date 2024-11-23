package com.facundosaracho.weatherapi.presentation.controller;

import com.facundosaracho.weatherapi.business.service.WeatherService;
import com.facundosaracho.weatherapi.presentation.dto.WeatherDataDto;
import com.facundosaracho.weatherapi.presentation.mapper.WeatherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather-api/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping()
    ResponseEntity<WeatherDataDto> getWeatherInformation() throws Exception {

        return new ResponseEntity<>(WeatherMapper.INSTANCE.toWeatherDto(weatherService.getWeatherInformation()), HttpStatus.OK);
    }
}

