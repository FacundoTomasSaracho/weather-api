package com.facundosaracho.weatherapi.presentation.mapper;

import com.facundosaracho.weatherapi.business.model.WeatherData;
import com.facundosaracho.weatherapi.presentation.dto.WeatherDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    WeatherDataDto toWeatherDto(WeatherData weatherData);
}
