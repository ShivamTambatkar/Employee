package com.humancloud.Employeemanagementsystem.Controller;

import com.humancloud.Employeemanagementsystem.DTO.*;
import com.humancloud.Employeemanagementsystem.Service.EmployeeService;
import com.humancloud.Employeemanagementsystem.Service.JwtService;
import com.humancloud.Employeemanagementsystem.Service.LeavesServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Tag(name = "Employee")
public class EmployeeController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeavesServices leavesServices;





    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        String employee = this.employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<String>(employee, HttpStatus.CREATED);
    }


    // Genereate Token and Login


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@Valid @RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }




    @PutMapping("/update/{empId}/rm/{rmId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeUpdateDTO employeeDTO,@PathVariable Integer rmId) {
        String employee = this.employeeService.updateEmployee(empId, employeeDTO,rmId);
        return new ResponseEntity<String>(employee, HttpStatus.OK);
    }

    @GetMapping("/allemp")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployee() {
        List<EmployeeResponseDTO> allEmployee = this.employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }
    @GetMapping("/search-employee/{keyword}")
    public ResponseEntity<List<EmployeeResponseDTO>> searchEmployee(@PathVariable String keyword) {
        List<EmployeeResponseDTO> employeeDTOS = this.employeeService.searchEmployee(keyword);
        return ResponseEntity.ok(employeeDTOS);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeResponseDTO> getSingleEmployee(@PathVariable Integer empId) {
        EmployeeResponseDTO singleEmployee = this.employeeService.getSingleEmployee(empId);
        return ResponseEntity.ok(singleEmployee);
    }



    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) {
        String message = this.employeeService.deleteEmployee(empId);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }






}
