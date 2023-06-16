package com.humancloud.Employeemanagementsystem.DTO;

import com.humancloud.Employeemanagementsystem.Entity.Leaves;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCategoryDTO {
    private Integer id;
    private  String categoryName;
}
