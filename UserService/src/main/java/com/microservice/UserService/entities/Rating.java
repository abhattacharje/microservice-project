package com.microservice.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;
}
