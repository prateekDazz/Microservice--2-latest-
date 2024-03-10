package net.prateekdazz.employeeservice.service;

import lombok.AllArgsConstructor;
import net.prateekdazz.employeeservice.dto.EmployeeDto;
import net.prateekdazz.employeeservice.entity.Employee;
import net.prateekdazz.employeeservice.exception.ResourceNotFoundException;
import net.prateekdazz.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee emp = employeeRepository.save(new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode()));
    return new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getDepartmentCode());
    }

    @Override
    public EmployeeDto fetchEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent())
        {
            throw new ResourceNotFoundException("employee","Id",id);

        }
        Employee e1 =  employee.get();
        return new EmployeeDto(e1.getId(),e1.getFirstName(),e1.getLastName(),e1.getEmail(),e1.getDepartmentCode());
    }

    @Override
    public Employee findByName(String firstName) {
        Optional<Employee> employee = employeeRepository.findByFirstName(firstName);
        if(!employee.isPresent())
        {
            return null;
        }
        return employee.get();
    }
}
