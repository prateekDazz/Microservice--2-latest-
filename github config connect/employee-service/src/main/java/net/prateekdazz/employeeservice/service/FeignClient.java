package net.prateekdazz.employeeservice.service;

import net.prateekdazz.employeeservice.dto.DepartmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(name = "DEPARTMENT-SERVICE")
public interface FeignClient {

    @GetMapping("/department/departmentCode/{departmentCode}")
    DepartmentDto findByDepartmentCode(@PathVariable("departmentCode") String departmentCode);
}
