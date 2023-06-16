package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private  String mobile;
    private EmployeeDTO reportingManager;
}
