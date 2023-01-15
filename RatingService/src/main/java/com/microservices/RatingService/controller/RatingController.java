package com.microservices.RatingService.controller;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating r = service.saveRating(rating);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @GetMapping("/getAllRatings")
    public List<Rating> getAllRatings() {
        return service.getAllRatings();
    }

    @GetMapping("/getRatingByUserId")
    public ResponseEntity<List<Rating>> getRatingByUserId(@RequestParam("userId") String userId) {
        List<Rating> ratings = service.getRatingByUserId(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/getRatingByHotelId")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@RequestParam("hotelId") String hotelId) {
        List<Rating> ratings = service.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
