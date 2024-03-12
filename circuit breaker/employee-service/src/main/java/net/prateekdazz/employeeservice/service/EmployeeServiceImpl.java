package net.prateekdazz.employeeservice.service;

import lombok.AllArgsConstructor;
import net.prateekdazz.employeeservice.dto.ApiResponseDto;
import net.prateekdazz.employeeservice.dto.DepartmentDto;
import net.prateekdazz.employeeservice.dto.EmployeeDto;
import net.prateekdazz.employeeservice.entity.Employee;
import net.prateekdazz.employeeservice.exception.ResourceNotFoundException;
import net.prateekdazz.employeeservice.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private WebClient webClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee emp = employeeRepository.save(new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode()));
    return new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getDepartmentCode());
    }

    @Override
//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod ="getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod ="getDefaultDepartment")
    public ApiResponseDto fetchEmployeeById(Long id) {
    	
    	LOGGER.info("EmployeeServiceImpl:: inside fetchEmployeeById() method ");
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent())
        {
            throw new ResourceNotFoundException("employee","Id",id);

        }
        Employee e1 =  employee.get();
        EmployeeDto employeeDto=new EmployeeDto(e1.getId(),e1.getFirstName(),e1.getLastName(),e1.getEmail(),e1.getDepartmentCode());
        DepartmentDto departmentDto =  webClient.get().uri("http://localhost:8080/department/departmentCode/"+employeeDto.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto,departmentDto);
        return apiResponseDto;
    }
 public ApiResponseDto getDefaultDepartment(Long employeeId,Exception e)
    
    {
	 
 	LOGGER.info("EmployeeServiceImpl:: inside getDefaultDepartment() method ");

    	 EmployeeDto employeeDto= findById(employeeId);
    	 DepartmentDto departmentDto = new DepartmentDto();
    	 departmentDto.setDepartmentCode("RD123");
    	 departmentDto.setDepartmentDescription("Research and Development");
    	 departmentDto.setDepartmentName("R&D");
    	 departmentDto.setId(34212);
    	 ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto,departmentDto);

         return apiResponseDto;
    	
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

	@Override
	public EmployeeDto findById(Long employeeId) {

		 Optional<Employee> employee = employeeRepository.findById(employeeId);
	        if(!employee.isPresent())
	        {
	            throw new ResourceNotFoundException("employee","Id",employeeId);

	        }
	        Employee e1 = employee.get();
	        return new EmployeeDto(e1.getId(),e1.getFirstName(),e1.getLastName(),e1.getEmail(),e1.getDepartmentCode());
	        }
}
