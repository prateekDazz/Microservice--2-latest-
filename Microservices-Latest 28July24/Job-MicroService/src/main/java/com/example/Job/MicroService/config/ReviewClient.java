package com.example.Job.MicroService.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Job.MicroService.external.Review;


@FeignClient(name = "REVIEW-MICROSERVICE")
@Component
public interface ReviewClient {
	@GetMapping("/reviews")
	List<Review>getAllReviewsForCompanyId(@RequestParam("companyId")long companyId);

}
