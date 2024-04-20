package net.prateekdazz.departmentservice.mapper;

import net.prateekdazz.departmentservice.dto.DepartmentDto;
import net.prateekdazz.departmentservice.entity.Department;

public class DepartmentMapper {
	
	public static DepartmentDto mapToDepartmentDto(Department d)
	{
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentCode(d.getDepartmentCode());
		departmentDto.setDepartmentDescription(d.getDepartmentDescription());
		departmentDto.setDepartmentName(d.getDepartmentName());
		departmentDto.setId(d.getId());
		return departmentDto;
	}
	
	public static Department mapToDepartment(DepartmentDto departmentDto)
	{
		Department d = new Department();
		d.setDepartmentCode(departmentDto.getDepartmentCode());
		d.setDepartmentDescription(departmentDto.getDepartmentDescription());
		d.setDepartmentName(departmentDto.getDepartmentName());
		d.setId(departmentDto.getId());
		return d;
	}

}
