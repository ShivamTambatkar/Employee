package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.Employee_Profile;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DegreeDTO {

    private String degreeName;
    private Date startdate;
    private Date endDate;
    private Double percentage;



}
