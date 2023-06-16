package com.humancloud.Employeemanagementsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", initialValue = 1, allocationSize = 1)
public class Employee {

    @Id
    @GeneratedValue(generator = "employee_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;


    private String name;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String mobile;

    private String roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Leaves> leaves;
    @ManyToOne
    @JoinColumn(name = "rmId")
    private Employee reportingManager;
    @OneToOne
    private  Employee_Profile employeeProfile;



}
