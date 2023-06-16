package com.humancloud.Employeemanagementsystem.Service;

import com.humancloud.Employeemanagementsystem.DTO.EmployeeProfileDto;

public interface Employee_ProfileService {

    String createEmployeeProfile(EmployeeProfileDto employeeProfileDto);
    String updateEmployeeProfile(EmployeeProfileDto employeeProfileDto,Integer empProfileId,Integer empId);

    EmployeeProfileDto getProfileOfEmployee(Integer empProfileId);
    String deleteEmployeeProfile(Integer empProfileId);
}
