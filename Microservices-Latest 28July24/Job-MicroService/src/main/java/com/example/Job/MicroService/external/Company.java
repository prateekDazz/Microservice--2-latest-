package com.example.Job.MicroService.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	private Long id;
	private String description;
	private String name;

}
