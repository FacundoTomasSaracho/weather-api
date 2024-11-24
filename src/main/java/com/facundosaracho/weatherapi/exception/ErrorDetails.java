package com.facundosaracho.weatherapi.exception;

import lombok.Getter;

@Getter
public enum ErrorDetails {

    //Server exceptions
    GENERIC_EXCEPTION(5000, "GENERIC ERROR"),
    RETROFIT_ERROR(5001, "Could not validate retrofit call."),

    //BusinessExceptions
    WEATHER_NOT_FOUND(4000, "Weather was not found");

    private final Integer code;
    private final String message;

    ErrorDetails(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
