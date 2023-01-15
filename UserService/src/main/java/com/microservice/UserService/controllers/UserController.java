package com.microservice.UserService.controllers;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("createUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User u = service.saveUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("getUserById")
//    @CircuitBreaker(name = "serviceDownBreaker", fallbackMethod = "serviceDownFallBack")
//    @Retry(name = "retryService", fallbackMethod = "serviceDownFallBack")
    @RateLimiter(name = "serviceRateLimiter", fallbackMethod = "serviceDownFallBack")
    public ResponseEntity<User> getUserById(@RequestParam("ID") String userId) {
        log.info("Retry attempted !!");
        User u = service.getUserById(userId);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    public ResponseEntity<User> serviceDownFallBack(String userId, Exception exception) {
        log.error("Service is down !!");
        User user = User.builder()
                .userId("123").name("dummy").email("dummy@abc.com").about("dummy about").ratings(List.of())
                .build();
        return new ResponseEntity<>(user, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
