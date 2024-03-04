package net.prateekdazz.departmentservice.service;

import lombok.AllArgsConstructor;
import net.prateekdazz.departmentservice.DepartmentServiceApplication;
import net.prateekdazz.departmentservice.dto.DepartmentDto;
import net.prateekdazz.departmentservice.entity.Department;
import net.prateekdazz.departmentservice.exception.ResourceNotFoundException;
import net.prateekdazz.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    @Override
    public Department findById(Long Id) {
        Optional<Department> d = departmentRepository.findById(Id);
        if(!d.isPresent())
        {
            throw new ResourceNotFoundException("department","Id",Id);

        }
        return d.get();
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department d = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());
        Department dep = departmentRepository.save(d);
        DepartmentDto depdto = new DepartmentDto(dep.getId(),dep.getDepartmentName(),dep.getDepartmentDescription(),dep.getDepartmentCode());
        return depdto;
    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        Optional<Department>department = departmentRepository.findByDepartmentName(departmentName);
        if(!department.isPresent())
        {
            return null;
        }
        return department.get();
    }

    @Override
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        Optional<Department>department = departmentRepository.findByDepartmentCode(departmentCode);
        if(!department.isPresent())
        {
            return null;
        }

        Department d1 =  department.get();
        return new DepartmentDto(d1.getId(),d1.getDepartmentName(),d1.getDepartmentDescription(), d1.getDepartmentCode());
    }
}
