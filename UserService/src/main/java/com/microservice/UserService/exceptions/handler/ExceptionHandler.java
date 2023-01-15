package com.microservice.UserService.exceptions.handler;

import com.microservice.UserService.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public final ResponseEntity<String> resourceNotFoundHandler(ResourceNotFoundException exception) {

        String response = exception.getUserId() + " NOT FOUND !!";
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
