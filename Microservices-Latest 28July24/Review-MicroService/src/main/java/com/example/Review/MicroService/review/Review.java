package com.example.Review.MicroService.review;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	private double rating;
	private long companyId;

}
