package com.microservices.RatingService.repository;

import com.microservices.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

    public List<Rating> findByUserId(String userId);
    public List<Rating> findByHotelId(String hotelId);
}
