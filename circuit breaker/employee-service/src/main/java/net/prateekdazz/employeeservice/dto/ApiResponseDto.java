package net.prateekdazz.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    public EmployeeDto employeeDto;
    public DepartmentDto departmentDto;
}
