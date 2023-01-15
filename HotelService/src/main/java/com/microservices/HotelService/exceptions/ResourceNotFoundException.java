package com.microservices.HotelService.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    String hotelId;

    public ResourceNotFoundException(String hotelId) {
        this.hotelId = hotelId;
    }
}
