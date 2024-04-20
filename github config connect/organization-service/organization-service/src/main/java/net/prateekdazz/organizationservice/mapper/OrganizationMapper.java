package net.prateekdazz.organizationservice.mapper;

import net.prateekdazz.organizationservice.dto.OrganizationDto;
import net.prateekdazz.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static Organization mapToOrganization(OrganizationDto organizationDto)
	{
		Organization organization = new Organization();
		organization.setCreatedDate(organizationDto.getCreatedDate());
		organization.setId(organizationDto.getId());
		organization.setOrganizationCode(organizationDto.getOrganizationCode());
		organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
		organization.setOrganizationName(organizationDto.getOrganizationName());
		return organization;
	}
	
	public static OrganizationDto mapToorganizationDto(Organization organization)
	{
		OrganizationDto organizationdto = new OrganizationDto ();
		organizationdto.setCreatedDate(organization.getCreatedDate());
		organizationdto.setId(organization.getId());
		organizationdto.setOrganizationCode(organization.getOrganizationCode());
		organizationdto.setOrganizationDescription(organization.getOrganizationDescription());
		organizationdto.setOrganizationName(organization.getOrganizationName());
		return organizationdto;
	}
	

}
