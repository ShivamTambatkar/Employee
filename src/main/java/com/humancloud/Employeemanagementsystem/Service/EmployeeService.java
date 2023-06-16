package com.humancloud.Employeemanagementsystem.Service;

import com.humancloud.Employeemanagementsystem.DTO.EmployeeDTO;
import com.humancloud.Employeemanagementsystem.DTO.EmployeeResponseDTO;
import com.humancloud.Employeemanagementsystem.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {

    String createEmployee(EmployeeDTO employeeDTO) ;

    String updateEmployee(Integer empId, EmployeeUpdateDTO employeeDTO,Integer reportingManagerId);

    List<EmployeeResponseDTO> getAllEmployee();

    EmployeeResponseDTO getSingleEmployee(Integer empId);

    String deleteEmployee(Integer empId);
    List <EmployeeResponseDTO> searchEmployee(String name);
}