package com.user.User.MicroService.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {


    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;

    private Hotel hotel;
}
