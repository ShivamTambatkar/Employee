package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Degree {
    @Id
    private String degreeName;
    private Date startdate;
    private Date endDate;
    private Double percentage;
    @ManyToOne
    @JoinColumn(name = "employee_profile_id")
    private Employee_Profile employeeProfile;
} 
