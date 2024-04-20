package net.prateekdazz.organizationservice.service;

import net.prateekdazz.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	
	public OrganizationDto saveOrganization(OrganizationDto organizationDto);
	public OrganizationDto getOrganizationByOrganizationCode(String organizationCode);
	
}
