package com.user.User.MicroService.service;

import com.user.User.MicroService.model.Employee;
import com.user.User.MicroService.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByfirstName(username);

        if(employee.isPresent())
        {
            if(employee.get().getHasManagerAccess()!=null && employee.get().getHasManagerAccess().equalsIgnoreCase("Y"))
            {
                return new User(username, employee.get().getPassword(), List.of(new SimpleGrantedAuthority("ROLE_MANAGER")));
            }
            return new User(username, employee.get().getPassword(),new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
