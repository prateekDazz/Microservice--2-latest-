package com.example.Job.MicroService.dto;

import java.util.List;

import com.example.Job.MicroService.external.Company;
import com.example.Job.MicroService.external.Review;
import com.example.Job.MicroService.job.Job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
	
	private Job job;
	private Company company;
	private List<Review> review;
	

}
