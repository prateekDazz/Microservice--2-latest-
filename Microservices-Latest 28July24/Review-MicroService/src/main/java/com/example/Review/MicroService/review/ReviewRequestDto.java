package com.example.Review.MicroService.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDto {
	
	private String title;
	private String description;
	private double rating;
	private long companyId;

}
