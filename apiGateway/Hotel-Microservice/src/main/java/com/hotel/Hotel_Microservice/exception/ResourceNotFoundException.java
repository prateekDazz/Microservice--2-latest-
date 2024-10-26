package com.hotel.Hotel_Microservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }
}
