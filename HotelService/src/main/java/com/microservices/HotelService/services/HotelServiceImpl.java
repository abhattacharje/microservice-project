package com.microservices.HotelService.services;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.exceptions.ResourceNotFoundException;
import com.microservices.HotelService.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo repo;

    @Override
    public Hotel createHotel(Hotel hotel) {

        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return repo.saveAndFlush(hotel);
    }

    @Override
    public List<Hotel> getHotels() {
        return repo.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return repo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(hotelId));
    }
}
