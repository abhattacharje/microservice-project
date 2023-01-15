package com.microservices.RatingService.service;

import com.microservices.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating saveRating(Rating rating);
    public List<Rating> getAllRatings();
    public List<Rating> getRatingByUserId(String userId);
    public List<Rating> getRatingByHotelId(String hotelId);
}
