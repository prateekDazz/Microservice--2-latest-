package com.example.Job.MicroService.job;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String maxSalary;
	private String minSalary;
	private String location;
private long companyId;
	
	

}
