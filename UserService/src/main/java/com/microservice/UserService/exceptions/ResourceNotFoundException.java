package com.microservice.UserService.exceptions;

import com.microservice.UserService.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private String userId;

    public ResourceNotFoundException(String userId) {
        this.userId = userId;
    }
}
