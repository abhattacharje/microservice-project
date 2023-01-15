package com.microservices.RatingService.exception.handler;

import com.microservices.RatingService.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundHandler(ResourceNotFoundException exception) {

        String response;
        if(exception.getSearchType().equals("user")) {
            response = "Rating corresponding to user-id "+exception.getId()+" not present";
        }
        else {
            response = "Rating corresponding to hotel-id "+exception.getId()+" not present";
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
