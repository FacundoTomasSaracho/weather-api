package com.facundosaracho.weatherapi.exception;

import lombok.Getter;

@Getter
public enum ErrorDetails {
    GENERIC_EXCEPTION(500, "GENERIC ERROR" ),
    WEATHER_NOT_FOUND(404, "Weather was not found");

    private final Integer code;
    private final String message;

    ErrorDetails(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
