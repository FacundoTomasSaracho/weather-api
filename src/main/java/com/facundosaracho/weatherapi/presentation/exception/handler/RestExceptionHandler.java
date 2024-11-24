package com.facundosaracho.weatherapi.presentation.exception.handler;

import com.facundosaracho.weatherapi.exception.RestException;
import com.facundosaracho.weatherapi.presentation.exception.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static com.facundosaracho.weatherapi.exception.ErrorDetails.GENERIC_EXCEPTION;
import static com.facundosaracho.weatherapi.exception.ErrorDetails.NO_RESOURCE_FOUND;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(RestException restException) {
        return new ResponseEntity<>(formErrorDto(restException), restException.getHttpStatusCode());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponseDto> handleGenericException() {
        return new ResponseEntity<>(formGenericErrorDto(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    ResponseEntity<ErrorResponseDto> handleInvalidResourceException() {
        return new ResponseEntity<>(formNoResourceFoundErrorDto(), HttpStatus.NOT_FOUND);
    }

    private ErrorResponseDto formErrorDto(RestException restException) {
        return new ErrorResponseDto(restException.getErrorDetails().getCode(), restException.getErrorDetails().getMessage());
    }

    private ErrorResponseDto formGenericErrorDto() {
        return new ErrorResponseDto(GENERIC_EXCEPTION.getCode(), GENERIC_EXCEPTION.getMessage());
    }

    private ErrorResponseDto formNoResourceFoundErrorDto() {
        return new ErrorResponseDto(NO_RESOURCE_FOUND.getCode(), NO_RESOURCE_FOUND.getMessage());
    }
}

