package com.example.Company.MicroService.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Company.MicroService.feignClient.ReviewClient;
import com.example.Company.MicroService.messaging.ReviewMessage;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService
{
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ReviewClient reviewClient;
	@Autowired
private RestTemplate restTemplate ;

	@Override
	public Company createCompany(CompanyRequestDto companyRequestDto) {
		Company company =  new Company();
		company.setDescription(companyRequestDto.getDescription());
		company.setName(companyRequestDto.getName());
		company  = companyRepository.save(company);
		return company;
	}

	@Override
	public Company updateCompany(Long Id, CompanyRequestDto companyRequestDto) {
		Company company =  companyRepository.findById(Id).orElseThrow(()->new IllegalArgumentException("No such id exists"));
		company.setDescription(companyRequestDto.getDescription());
		company.setName(companyRequestDto.getName());
		company  = companyRepository.save(company);
		return company;
	}

	@Override
	public Company fetchCompany(Long id) {
		Company company =  companyRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No such id exists"));

		return company;
	}

	@Override
	public List<Company> fetchAllCompany() {
		List<Company>company = companyRepository.findAll();
		return company;
	}

	@Override
	public Company deleteCompanyById(Long id) {
		Company company =  companyRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No such id exists"));

		  companyRepository.deleteById(id);
		return company;
	}

	@Override
	public void updateCompanyMessage(ReviewMessage reviewMessage) throws IllegalAccessException {
System.out.println("review message description h"+reviewMessage.getDescription());
long companyId = reviewMessage.getCompanyId();
Double averageRating = reviewClient.getAverageRating(companyId);
Company company = companyRepository.findById(reviewMessage.getCompanyId()).orElseThrow(()->new IllegalAccessException());
company.setRating(averageRating);
companyRepository.save(company);
	}

}
