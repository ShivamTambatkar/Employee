package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "leaveCategory")
    private List<Leaves> leaves;

}
