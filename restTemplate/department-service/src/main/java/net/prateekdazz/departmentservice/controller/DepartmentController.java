package net.prateekdazz.departmentservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.prateekdazz.departmentservice.dto.DepartmentDto;
import net.prateekdazz.departmentservice.entity.Department;
import net.prateekdazz.departmentservice.exception.ResourceNotFoundException;
import net.prateekdazz.departmentservice.exception.UserAlreadyExistsException;
import net.prateekdazz.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto>saveDepartment(@RequestBody DepartmentDto departmentDto)
    {
        Department d = departmentService.findByDepartmentName(departmentDto.getDepartmentName());
        if(d!=null)
        {
            throw new UserAlreadyExistsException(departmentDto.getDepartmentName(),departmentDto.getId());
        }
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return ResponseEntity.ok(departmentDto1);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department>findByDepartmentId(@PathVariable("departmentId")Long departmentId){
        Department d= departmentService.findById(departmentId);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<DepartmentDto>findByDepartmentCode(@PathVariable("departmentCode") String departmentCode)
    {
        DepartmentDto departmentDto =  departmentService.findByDepartmentCode(departmentCode);
        return ResponseEntity.ok(departmentDto);
    }
}
