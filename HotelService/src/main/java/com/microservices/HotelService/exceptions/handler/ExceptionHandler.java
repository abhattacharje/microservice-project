package com.microservices.HotelService.exceptions.handler;

import com.microservices.HotelService.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundHandler(ResourceNotFoundException exception) {

        String response = exception.getHotelId() + " not found !!";
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
