package com.group7.be.advice.handler;

import com.group7.be.advice.custom.ResourceNotFoundException;
import com.group7.be.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonHandlerException {
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse resourceNotFound(ResourceNotFoundException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
