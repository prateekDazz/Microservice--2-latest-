package net.prateekdazz.employeeservice.mapper;

import net.prateekdazz.employeeservice.dto.EmployeeDto;
import net.prateekdazz.employeeservice.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee e)
	{
		EmployeeDto employeeDto = new EmployeeDto();
	employeeDto.setDepartmentCode(e.getDepartmentCode());
	employeeDto.setEmail(e.getEmail());
	employeeDto.setFirstName(e.getFirstName());
	employeeDto.setId(e.getId());
	employeeDto.setLastName(e.getLastName());
	employeeDto.setOrganizationCode(e.getOrganizationCode());
	return employeeDto;
	
	}	
	public static Employee mapToEmployee(EmployeeDto employeeDto)
	{
	Employee e = new Employee();
	e.setDepartmentCode(employeeDto.getDepartmentCode());
	e.setEmail(employeeDto.getEmail());
	e.setFirstName(employeeDto.getFirstName());
	e.setId(employeeDto.getId());
	e.setLastName(employeeDto.getLastName());
	e.setOrganizationCode(employeeDto.getOrganizationCode());
		return e;
		
	}

}
