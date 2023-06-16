package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String reasons;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leaveCategory_id")
    private LeaveCategory leaveCategory;
    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;


}
