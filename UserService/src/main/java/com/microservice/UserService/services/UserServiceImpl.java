package com.microservice.UserService.services;

import com.microservice.UserService.entities.Hotel;
import com.microservice.UserService.entities.Rating;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exceptions.ResourceNotFoundException;
import com.microservice.UserService.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    private static final String ratingURL = "http://RATING-SERVICE/rating/getRatingByUserId?userId=";

    private static final String hotelURL = "http://HOTEL-SERVICE/hotel/getHotelById?ID=";

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return repo.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        ResponseEntity<List<Rating>> ratingResponse = restTemplate.exchange(ratingURL+user.getUserId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>(){});
        List<Rating> ratings = ratingResponse.getBody();
        ratings.forEach(r -> {
            ResponseEntity<Hotel> hotelResponse = restTemplate.exchange(hotelURL+r.getHotelId(), HttpMethod.GET, null, Hotel.class);
            Hotel h = hotelResponse.getBody();
            r.setHotel(h);
        });
        user.setRatings(ratings);
        return user;
    }
}
