package net.prateekdazz.employeeservice.service;

import net.prateekdazz.employeeservice.dto.EmployeeDto;
import net.prateekdazz.employeeservice.entity.Employee;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);


    public EmployeeDto fetchEmployeeById(Long id);


    Employee findByName(String firstName);
}
