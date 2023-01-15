package com.microservices.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name = "ID")
    private String ratingId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "HOTEL_ID")
    private String hotelId;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "FEEDBACK")
    private String feedback;
}
