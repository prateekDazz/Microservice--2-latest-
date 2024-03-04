
package net.prateekdazz.employeeservice.controllers;

import lombok.AllArgsConstructor;
import net.prateekdazz.employeeservice.dto.ApiResponseDto;
import net.prateekdazz.employeeservice.dto.DepartmentDto;
import net.prateekdazz.employeeservice.dto.EmployeeDto;
import net.prateekdazz.employeeservice.entity.Employee;
import net.prateekdazz.employeeservice.exception.UserAlreadyExistsException;
import net.prateekdazz.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    private RestTemplate restTemplate;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {

        Employee employee = employeeService.findByName(employeeDto.getFirstName());
        if(employee!=null)
        {
            throw new UserAlreadyExistsException(employeeDto.getFirstName(),employee.getId());
        }
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponseDto>findByEmployeeId(@PathVariable("employeeId")Long employeeId){
        EmployeeDto employeeDto= employeeService.fetchEmployeeById(employeeId);
       ResponseEntity<DepartmentDto>departmentDtoResponseEntity= restTemplate.getForEntity("http://localhost:8080/department/departmentCode/"+employeeDto.getDepartmentCode(), DepartmentDto.class);
      DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
      ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto,departmentDto);

        return ResponseEntity.ok(apiResponseDto);
    }
}
