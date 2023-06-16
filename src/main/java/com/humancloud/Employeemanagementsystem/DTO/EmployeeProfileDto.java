package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.Address;
import com.humancloud.Employeemanagementsystem.Entity.Degree;
import com.humancloud.Employeemanagementsystem.Entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfileDto {


    private Integer id;
    @Size(min = 3, max=20)
    private String firstName;
    @Size(min = 3, max=20)
    private String lastName;

    private  String Image;

    private Address address;

    private List<DegreeDTO> degree;



}
