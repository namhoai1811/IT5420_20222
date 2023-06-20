package com.group7.be.advice.handler;

import com.group7.be.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class AuthenticationHandlerException {
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse constraintViolation(SQLIntegrityConstraintViolationException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ExceptionResponse usernameNotFound(UsernameNotFoundException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.FORBIDDEN.value());
    }
}
