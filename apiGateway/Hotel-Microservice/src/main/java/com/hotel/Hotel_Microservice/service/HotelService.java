package com.hotel.Hotel_Microservice.service;

import com.hotel.Hotel_Microservice.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
