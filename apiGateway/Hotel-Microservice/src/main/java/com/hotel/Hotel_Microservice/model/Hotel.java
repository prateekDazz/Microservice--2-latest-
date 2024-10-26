package com.hotel.Hotel_Microservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotels")
public class Hotel {
    @Id
    private  String id;
    private  String name;
    private  String location;
    private  String about;
}
