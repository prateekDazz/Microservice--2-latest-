package com.example.Job.MicroService.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRequestDto {
	
	private String title;
	private String description;
	private String maxSalary;
	private String minSalary;
	private String location;
	private long companyId;

}
