package com.example.Job.MicroService.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Job.MicroService.external.Company;
@FeignClient(name = "COMPANY-MICROSERVICE")
@Component
public interface CompanyClient {
	@GetMapping("/api/company")
	Company getCompany(@RequestParam("id")  Long id);

}
