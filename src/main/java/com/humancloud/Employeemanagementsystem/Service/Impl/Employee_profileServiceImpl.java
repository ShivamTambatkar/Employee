package com.humancloud.Employeemanagementsystem.Service.Impl;

import com.humancloud.Employeemanagementsystem.DTO.EmployeeProfileDto;
import com.humancloud.Employeemanagementsystem.Entity.Employee;
import com.humancloud.Employeemanagementsystem.Entity.Employee_Profile;
import com.humancloud.Employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.humancloud.Employeemanagementsystem.Repository.EmployeeProfileRepository;
import com.humancloud.Employeemanagementsystem.Repository.EmployeeRepository;
import com.humancloud.Employeemanagementsystem.Service.Employee_ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Employee_profileServiceImpl implements Employee_ProfileService {
    @Autowired
    private EmployeeProfileRepository employeeProfileRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployeeProfile(EmployeeProfileDto employeeProfileDto) {
        Employee_Profile employeeProfile = modelMapper.map(employeeProfileDto, Employee_Profile.class);
        employeeProfileRepository.save(employeeProfile);

        return "Profile Created";
    }

    @Override
    public String updateEmployeeProfile(EmployeeProfileDto employeeProfileDto, Integer empProfileId, Integer empId) {

        Employee_Profile employeeProfile = employeeProfileRepository.findById(empProfileId).orElseThrow(() -> new ResourceNotFoundException("employeeProfile", "empProfileId", empProfileId));
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee", "empId", empId));
        employeeProfile.setEmployee(employee);
        employeeProfile.setId(employeeProfileDto.getId());
        employeeProfile.setImage(employeeProfileDto.getImage());
        employeeProfile.setAddress(employeeProfileDto.getAddress());
        employeeProfile.setFirstName(employeeProfileDto.getFirstName());
        employeeProfile.setLastName(employeeProfileDto.getLastName());
        employeeProfileRepository.save(employeeProfile);

        return "Employee Profile updated successfully";
    }

    @Override
    public EmployeeProfileDto getProfileOfEmployee(Integer empProfileId) {

        Employee_Profile employeeProfile = employeeProfileRepository.
                findById(empProfileId).orElseThrow(() -> new ResourceNotFoundException
                        ("EmployeeProfile", "EmployeeProfileDto", empProfileId));

        EmployeeProfileDto map = modelMapper.map(employeeProfile, EmployeeProfileDto.class);

        EmployeeProfileDto profileDto = modelMapper.map(employeeProfile, EmployeeProfileDto.class);
        return profileDto;
    }

    @Override
    public String deleteEmployeeProfile(Integer empProfileId) {

        employeeProfileRepository.deleteById(empProfileId);
        return "employeeDeleted SuccessFully";
    }
}
