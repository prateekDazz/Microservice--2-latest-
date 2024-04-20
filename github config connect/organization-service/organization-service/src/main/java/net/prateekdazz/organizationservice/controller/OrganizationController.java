package net.prateekdazz.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.prateekdazz.organizationservice.dto.OrganizationDto;
import net.prateekdazz.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("/organization")
@AllArgsConstructor
public class OrganizationController {
	
	private OrganizationService organizationService;
	@PostMapping("/saveOrganization")
	
	public ResponseEntity<OrganizationDto>saveOrganization(@RequestBody OrganizationDto organizationDto)
	{
		OrganizationDto organizationDto2 = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(organizationDto2,HttpStatus.CREATED);
	}
	@GetMapping("/{organizationCode}")
	
	public ResponseEntity<OrganizationDto>findByOrganizationCode(@PathVariable("organizationCode")String organizationCode)
	{
		OrganizationDto organizationDto = organizationService.getOrganizationByOrganizationCode(organizationCode);
		return new ResponseEntity<>(organizationDto,HttpStatus.OK);
	}

}
