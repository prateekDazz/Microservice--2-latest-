package net.prateekdazz.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
private String departmentName;

private String departmentDescription;
private String departmentCode;


}
