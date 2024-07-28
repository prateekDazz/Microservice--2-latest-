package com.example.Job.MicroService.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Job.MicroService.config.CompanyClient;
import com.example.Job.MicroService.config.ReviewClient;
import com.example.Job.MicroService.dto.JobDto;
import com.example.Job.MicroService.external.Company;
import com.example.Job.MicroService.external.Review;
import com.netflix.discovery.converters.Auto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepository;

	
	private static Logger logger  =  LoggerFactory.getLogger(JobServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CompanyClient companyClient;
	@Autowired
	private ReviewClient reviewClient;
	int attempt=0;

	@Override
	public Job createJob(JobRequestDto jobRequestDto) {
		
		logger.info("inside create Job(){}");
		Job job = new Job();
//		long id = jobRequestDto.getCompany().getId();
//		Company company = companyRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Illegal Access specifier"));
		job.setDescription(jobRequestDto.getDescription());
		job.setLocation(jobRequestDto.getLocation());
		job.setMinSalary(jobRequestDto.getMinSalary());
		job.setMaxSalary(jobRequestDto.getMaxSalary());
		job.setTitle(jobRequestDto.getTitle());
		job.setCompanyId(jobRequestDto.getCompanyId());		
		
		jobRepository.save(job);
		logger.info("returning job as {}"+job);

		return job;
	}


	@Override
//	@CircuitBreaker(name = "companyBreaker",fallbackMethod = "companyBreakerFallBack")
	@Retry(name = "companyBreaker",fallbackMethod = "companyBreakerFallBack")
	public List<JobDto> fetchAllJobs() {
		attempt+=1;
		System.out.println("no of attempts ="+attempt);
		logger.info("inside fetchAllJobsMethod{}");
		
		List<Job>resultList  =  jobRepository.findAll();
		
//		for(Job jobs:resultList){
//			JobCompanyDto jobCompanyDto = new JobCompanyDto();
//			jobCompanyDto.setJob(jobs);
//			RestTemplate restTemplate = new RestTemplate();
//			Company company = restTemplate.getForObject("http://localhost:8081/api/company?id="+jobs.getCompanyId(), Company.class);
//			jobCompanyDto.setCompany(company);
//			jobCompanyDtos.add(jobCompanyDto);
//		}
			
		return resultList.stream().map(this::getJobCompanyDto).collect(Collectors.toList());
	}
	
	public List<String> companyBreakerFallBack(Exception e)
	{
		
		
		return Arrays.asList("Company Microservice is Down");
	}
	
	
	public JobDto getJobCompanyDto(Job job)
	{
		JobDto jobDto = new JobDto();
		jobDto.setJob(job);
//		RestTemplate restTemplate = new RestTemplate();
		Company company = restTemplate.getForObject("http://COMPANY-MICROSERVICE:8081/api/company?id="+job.getCompanyId(), Company.class);
		jobDto.setCompany(company);
		return jobDto;
	}

	@Override
//	@CircuitBreaker(name = "companyBreaker",fallbackMethod = "companyBreakerFallBack")
	public JobDto fetchJobByJobId(Long jobId) {
		logger.info("inside fetchJobByJobId() with job id as {}"+jobId);
//		RestTemplate restTemplate = new RestTemplate();
//		Company company = restTemplate.getForObject("http://localhost:8081/api/company?id=1", Company.class);
//		System.out.println("the value of company object is ::"+company);

		Job job = jobRepository.findById(jobId).orElseThrow(()->new JobNotExistsException("No such Job with "+ jobId+ " exists"));
		Company company = companyClient.getCompany(job.getCompanyId());
//Company  company = restTemplate.getForObject("http://COMPANY-MICROSERVICE:8081/api/company?id="+job.getCompanyId(), Company.class);
//ResponseEntity<List<Review>>reviewList = restTemplate.exchange("http://REVIEW-MICROSERVICE:8083/reviews?companyId="+job.getCompanyId(), HttpMethod.GET, null,
//		
//		new ParameterizedTypeReference<List<Review>>() {
//		});
		List<Review> reviewList =  reviewClient.getAllReviewsForCompanyId(job.getCompanyId());
JobDto jobDto = new JobDto();
jobDto.setCompany(company);
jobDto.setJob(job);
//jobDto.setReview(reviewList.getBody());
jobDto.setReview(reviewList);

return jobDto;

	}

	@Override
	public Job updateJobByJobId(Long jobId,JobRequestDto jobRequestDto) {
		logger.info("inside updateJobByJobId() with job id as {}"+jobId);

		
		Job job = jobRepository.findById(jobId).orElseThrow(()->new JobNotExistsException("No such Job with "+ jobId+ " exists"));
job.setDescription(jobRequestDto.getDescription());
job.setLocation(jobRequestDto.getLocation());
job.setMaxSalary(jobRequestDto .getMaxSalary());
job.setMinSalary(jobRequestDto.getMinSalary());
job.setTitle(jobRequestDto.getTitle());
jobRepository.save(job);
return job;
	}

	@Override
	public Job deleteJobByJobId(Long jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(()->new JobNotExistsException("No such Job with "+ jobId+ " exists"));
		
		jobRepository.delete(job);
		return job;
	}

}
