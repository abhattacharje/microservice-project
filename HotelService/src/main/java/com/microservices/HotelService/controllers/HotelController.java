package com.microservices.HotelService.controllers;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel h = service.createHotel(hotel);
        return new ResponseEntity<>(h, HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels() {
        return service.getHotels();
    }

    @GetMapping("/getHotelById")
    public ResponseEntity<Hotel> getHotelById(@RequestParam("ID") String hotelId) {
        Hotel h = service.getHotelById(hotelId);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }
}
