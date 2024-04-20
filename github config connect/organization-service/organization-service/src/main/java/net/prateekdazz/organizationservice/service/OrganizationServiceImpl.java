package net.prateekdazz.organizationservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.prateekdazz.organizationservice.dto.OrganizationDto;
import net.prateekdazz.organizationservice.entity.Organization;
import net.prateekdazz.organizationservice.mapper.OrganizationMapper;
import net.prateekdazz.organizationservice.repository.OrganizationRepository;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	
	private OrganizationRepository organizationRepository;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization =  organizationRepository.save(organization);
		return OrganizationMapper.mapToorganizationDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByOrganizationCode(String organizationCode) {
		
		Optional<Organization> organization =  organizationRepository.findByOrganizationCode(organizationCode);
		OrganizationDto organizationDto = OrganizationMapper.mapToorganizationDto(organization.get());
		return organizationDto;
	}
	
	

}
