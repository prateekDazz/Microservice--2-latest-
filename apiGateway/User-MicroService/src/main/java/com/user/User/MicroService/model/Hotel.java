package com.user.User.MicroService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private  String id;
    private  String name;
    private  String location;
    private  String about;
}
