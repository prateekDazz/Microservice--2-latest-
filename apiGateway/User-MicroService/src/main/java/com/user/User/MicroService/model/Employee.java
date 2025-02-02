package com.user.User.MicroService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private int employeeId;
    private int managerId;
    @Column(nullable = false)
    private String firstName;
    private String hasManagerAccess;
    private String lastName;
    private String password;
}
