package com.facundosaracho.weatherapi.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends RestException {

    public BusinessException(Integer code, String message, HttpStatus httpStatus) {
        super(code, message, httpStatus);
    }
}
