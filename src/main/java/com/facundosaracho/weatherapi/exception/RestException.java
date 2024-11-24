package com.facundosaracho.weatherapi.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestException extends RuntimeException {
    private final ErrorDetails errorDetails;
    private final HttpStatus httpStatusCode;

    public RestException(ErrorDetails errorDetails, HttpStatus httpStatus) {
        this.errorDetails = errorDetails;
        this.httpStatusCode = httpStatus;
    }

}
