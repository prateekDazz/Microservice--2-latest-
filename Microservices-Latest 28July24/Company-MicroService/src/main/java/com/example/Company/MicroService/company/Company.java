package com.example.Company.MicroService.company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private String name;
	private Double Rating;


}
