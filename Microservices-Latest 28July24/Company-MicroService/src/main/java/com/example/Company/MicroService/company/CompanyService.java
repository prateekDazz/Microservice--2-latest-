package com.example.Company.MicroService.company;

import org.springframework.stereotype.Component;

import com.example.Company.MicroService.messaging.ReviewMessage;

import java.util.List;
@Component
public interface CompanyService {
	
	Company createCompany(CompanyRequestDto companyRequestDto);
	
	Company updateCompany(Long Id,CompanyRequestDto companyRequestDto);
	Company fetchCompany(Long id);
	List<Company>fetchAllCompany();
	Company deleteCompanyById(Long Id);

	void updateCompanyMessage(ReviewMessage reviewMessage) throws IllegalAccessException;
	
	


}
