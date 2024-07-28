package com.example.Company.MicroService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Review-MicroService")
@Component
public interface ReviewClient {
	@GetMapping("/reviews/averageRating")
	public Double getAverageRating(@RequestParam("companyId")long companyId);

}
