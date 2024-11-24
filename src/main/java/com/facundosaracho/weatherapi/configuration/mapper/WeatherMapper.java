package com.facundosaracho.weatherapi.configuration.mapper;

import com.facundosaracho.weatherapi.business.model.WeatherData;
import com.facundosaracho.weatherapi.business.model.client.weatherpapi.WeatherApiResponse;
import com.facundosaracho.weatherapi.presentation.dto.WeatherDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "city", source = "location.name")
    @Mapping(target = "weather", source = "current.condition.text")
    WeatherData toWeatherData(WeatherApiResponse weatherApiResponse);

    WeatherDataDto toWeatherDto(WeatherData weatherData);

}
