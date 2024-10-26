package com.user.User.MicroService.repo;

import com.user.User.MicroService.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByManagerId(int managerId);

    Optional<Employee>findByfirstName(String firstName);
}
