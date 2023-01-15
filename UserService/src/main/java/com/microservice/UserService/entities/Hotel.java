package com.microservice.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private String about;
}
