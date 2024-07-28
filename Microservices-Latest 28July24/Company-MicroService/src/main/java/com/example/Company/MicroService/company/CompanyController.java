package com.example.Company.MicroService.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<Company> fetchCompanyByCompanyId(@RequestParam("id") long id) {
		Company company = companyService.fetchCompany(id);
		return ResponseEntity.ok(company);
	}

	@GetMapping("/fetchAllCompany")
	public ResponseEntity<List<Company>> fetchAllCompany() {
		List<Company> companyList = companyService.fetchAllCompany();
		return ResponseEntity.ok(companyList);
	}

	@PutMapping

	public ResponseEntity<Company> updateCompanyDetails(@RequestBody CompanyRequestDto companyRequestDto,
			@RequestParam Long id) {
		Company company = companyService.updateCompany(id, companyRequestDto);
		return ResponseEntity.ok(company);
	}
	
	@PostMapping

	public ResponseEntity<Company> createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
		Company company = companyService.createCompany(companyRequestDto);
		return ResponseEntity.ok(company);
	}
	@DeleteMapping

	public ResponseEntity<Company> deleteCompany(@RequestParam("id")long companyId) {
		Company company = companyService.deleteCompanyById(companyId);
		return ResponseEntity.ok(company);
	}


}
