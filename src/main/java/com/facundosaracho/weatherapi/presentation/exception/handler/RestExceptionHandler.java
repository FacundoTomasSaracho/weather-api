package com.facundosaracho.weatherapi.presentation.exception.handler;

import com.facundosaracho.weatherapi.exception.BusinessException;
import com.facundosaracho.weatherapi.presentation.exception.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.facundosaracho.weatherapi.exception.ErrorDetails.GENERIC_EXCEPTION;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException businessException) {
        return new ResponseEntity<>(new ErrorResponseDto(
                businessException.getCode(),
                businessException.getMessage()),
                businessException.getHttpStatusCode());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponseDto> handleGenericException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDto(
                GENERIC_EXCEPTION.getCode(),
                GENERIC_EXCEPTION.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

