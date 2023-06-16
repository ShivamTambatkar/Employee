package com.humancloud.Employeemanagementsystem.Controller;

import com.humancloud.Employeemanagementsystem.DTO.EmployeeProfileDto;
import com.humancloud.Employeemanagementsystem.Entity.Employee_Profile;
import com.humancloud.Employeemanagementsystem.Service.Employee_ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp-profile")
@Tag(name = "EmployeeProfile")
public class EmployeeProfileController {
    @Autowired
    private Employee_ProfileService employeeProfileService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployeeProfile(EmployeeProfileDto employeeProfileDto) {
        String employeeProfile = employeeProfileService.createEmployeeProfile(employeeProfileDto);
        return new ResponseEntity<String>(employeeProfile, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeeProfile(EmployeeProfileDto employeeProfileDto, Integer empProfileId, Integer empId) {
        String updateEmployeeProfile = employeeProfileService.updateEmployeeProfile(employeeProfileDto, empProfileId, empId);
        return ResponseEntity.ok(updateEmployeeProfile);
    }
@GetMapping("/{empProfileId}")
    public ResponseEntity<EmployeeProfileDto> getEmployeeProfileById(@PathVariable Integer empProfileId) {
        EmployeeProfileDto profileOfEmployee = employeeProfileService.getProfileOfEmployee(empProfileId);
        return ResponseEntity.ok(profileOfEmployee);
    }

    @DeleteMapping("/{empProfileId}")
    public ResponseEntity<String> deleteEmployeeProfileById(@PathVariable Integer empProfileId) {
        String deleteEmployeeProfile = employeeProfileService.deleteEmployeeProfile(empProfileId);
        return ResponseEntity.ok(deleteEmployeeProfile);
    }

}
