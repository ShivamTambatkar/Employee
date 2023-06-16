package com.humancloud.Employeemanagementsystem.Service.Impl;

import com.humancloud.Employeemanagementsystem.DTO.EmployeeDTO;
import com.humancloud.Employeemanagementsystem.DTO.EmployeeResponseDTO;
import com.humancloud.Employeemanagementsystem.DTO.EmployeeUpdateDTO;
import com.humancloud.Employeemanagementsystem.Entity.Employee;
import com.humancloud.Employeemanagementsystem.Exceptions.EmailAllReadyExitsException;
import com.humancloud.Employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.humancloud.Employeemanagementsystem.Helper.ErrorResponse;
import com.humancloud.Employeemanagementsystem.Repository.EmployeeRepository;
import com.humancloud.Employeemanagementsystem.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository  employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public  boolean exitsByEmail(String email){
        return this.employeeRepository.existsByEmail(email);
    }

    @Override
    public String createEmployee(EmployeeDTO employeeDTO) {
        if (exitsByEmail(employeeDTO.getEmail())) {
            throw new EmailAllReadyExitsException("User","EmailId",employeeDTO.getEmail());
        } else {

            Employee employee = modelMapper.map(employeeDTO, Employee.class);

            employee.setPassword(passwordEncoder.encode(employee.getPassword()));


            this.employeeRepository.save(employee);
            return "Hurray !! Employee Register Successfully !!!";
        }
    }



    @Override
    public String updateEmployee(Integer empId, EmployeeUpdateDTO employeeDTO,Integer reportingManagerId) {
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee","empId ",empId));
        Employee repotingManager = employeeRepository.findById(reportingManagerId).orElseThrow(() -> new ResourceNotFoundException("employee", "empId ", empId));

        employee.setMobile(employeeDTO.getMobile()!=null ? employeeDTO.getMobile() : employee.getMobile());
        employee.setName(employeeDTO.getName()!=null ? employeeDTO.getName() : employee.getName() );
        employee.setEmail(employeeDTO.getEmail()!=null ? employeeDTO.getEmail() : employee.getEmail() );
        employee.setPassword(employeeDTO.getPassword()!=null ? employeeDTO.getPassword() : employee.getPassword() );
        employee.setRoles(employeeDTO.getRoles()!=null ? employeeDTO.getRoles():employee.getRoles());
        employee.setReportingManager(repotingManager);

        this.employeeRepository.save(employee);
        return "Hurray!! Employee updated SuccessFully";
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployee() {
        List<Employee> employeeList = this.employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeDTOS = employeeList.stream().map(emp -> this.modelMapper.map(emp, EmployeeResponseDTO.class)).collect(Collectors.toList());
        return  employeeDTOS;
    }

    @Override
    public EmployeeResponseDTO getSingleEmployee(Integer empId) {
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee","empId ",empId));
        return this.modelMapper.map(employee,EmployeeResponseDTO.class);

    }

    @Override
    public String deleteEmployee(Integer empId) {
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee","empId ",empId));
        this.employeeRepository.delete(employee);
        return "Employee Deleted Successfully";
    }

    @Override
    public List<EmployeeResponseDTO> searchEmployee(String name) {
        List<Employee> searchedEmployee = this.employeeRepository.findByNameContaining(name);
        List<EmployeeResponseDTO> employeeDTOS = searchedEmployee.stream().map(employee  -> modelMapper.map(employee, EmployeeResponseDTO.class)).collect(Collectors.toList());
        return employeeDTOS;
    }
}
