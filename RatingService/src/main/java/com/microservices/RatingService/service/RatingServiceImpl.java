package com.microservices.RatingService.service;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.exception.ResourceNotFoundException;
import com.microservices.RatingService.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo repo;

    @Override
    public Rating saveRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return repo.saveAndFlush(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> ratings = repo.findByUserId(userId);
        if(ratings.isEmpty()) {
            throw new ResourceNotFoundException(userId, "user");
        }
        return ratings;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        List<Rating> ratings = repo.findByHotelId(hotelId);
        if(ratings.isEmpty()) {
            throw new ResourceNotFoundException(hotelId, "hotel");
        }
        return ratings;
    }
}
