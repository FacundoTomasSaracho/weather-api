package com.facundosaracho.weatherapi.exception;

import org.springframework.http.HttpStatus;

public class ClientException extends RestException {
    public ClientException(Integer code, String message, HttpStatus httpStatus) {
        super(code, message, httpStatus);
    }
}
