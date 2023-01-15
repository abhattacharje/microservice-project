package com.microservices.RatingService.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    String id;
    String searchType;

    public ResourceNotFoundException(String id, String searchType) {
        this.id = id;
        this.searchType = searchType;
    }
}
