package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee_Profile {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private  String Image;
    @Embedded
    private  Address address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeProfile")
    private List<Degree> degree;
    @OneToOne
    private Employee employee;
}
