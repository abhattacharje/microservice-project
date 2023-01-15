package com.microservices.HotelService.services;

import com.microservices.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(Hotel hotel);
    public List<Hotel> getHotels();
    public Hotel getHotelById(String hotelId);
}
