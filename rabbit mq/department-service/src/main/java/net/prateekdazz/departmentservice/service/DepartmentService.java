package net.prateekdazz.departmentservice.service;

import net.prateekdazz.departmentservice.dto.DepartmentDto;
import net.prateekdazz.departmentservice.entity.Department;

public interface DepartmentService {

    public Department findById(Long Id);
    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    Department findByDepartmentName(String departmentName);

    DepartmentDto findByDepartmentCode(String departmentCode);
}
