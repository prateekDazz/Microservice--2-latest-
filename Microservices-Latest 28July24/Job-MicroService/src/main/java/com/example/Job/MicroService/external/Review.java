package com.example.Job.MicroService.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	private long id;
	private String title;
	private String description;
	private double rating;

}
