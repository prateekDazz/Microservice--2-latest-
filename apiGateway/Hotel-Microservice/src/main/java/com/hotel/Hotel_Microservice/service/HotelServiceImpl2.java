package com.hotel.Hotel_Microservice.service;

import com.hotel.Hotel_Microservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("foo2")
public class HotelServiceImpl2  implements  HotelService{
    @Override
    public Hotel create(Hotel hotel) {
        return null;
    }

    @Override
    public List<Hotel> getAll() {
        return null;
    }

    @Override
    public Hotel get(String id) {
        return null;
    }
}
