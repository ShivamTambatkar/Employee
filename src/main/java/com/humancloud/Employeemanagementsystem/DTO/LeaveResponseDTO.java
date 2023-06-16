package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.LeaveCategory;
import com.humancloud.Employeemanagementsystem.Entity.LeaveStatus;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveResponseDTO {
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String reasons;

    private LeaveCategory leaveCategory;
    private LeaveStatus leaveStatus;
}
