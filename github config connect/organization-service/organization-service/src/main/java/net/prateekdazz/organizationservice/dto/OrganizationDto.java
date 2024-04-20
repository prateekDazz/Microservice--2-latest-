package net.prateekdazz.organizationservice.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
	
private Long id;
private String organizationName;
private String organizationDescription;
private String organizationCode;
private LocalDateTime createdDate;

}
