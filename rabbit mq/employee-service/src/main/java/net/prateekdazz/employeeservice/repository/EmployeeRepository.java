package net.prateekdazz.employeeservice.repository;

import net.prateekdazz.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    Optional<Employee> findByFirstName(String firstName);
}
