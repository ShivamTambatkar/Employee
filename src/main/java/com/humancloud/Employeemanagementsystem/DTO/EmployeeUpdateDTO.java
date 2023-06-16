package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.Employee;
import com.humancloud.Employeemanagementsystem.Entity.Leaves;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDTO {


    private Integer id;
    private String name;
    private String email;
    private String password;
    private  String mobile;

    private String roles;



}
