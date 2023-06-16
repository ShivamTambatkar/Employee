package com.humancloud.Employeemanagementsystem.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.humancloud.Employeemanagementsystem.Entity.Leaves;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Integer id;
    @NotEmpty
    @Size(min = 4,message = "Username must be min of character of 4 characters !!!")
    private String name;
    @Email(message = "Email address is not valid !!! ")
    private String email;
    @NotEmpty

    @Size(min = 3, max = 10,message = "password should be between 3-10 charaters")
    @JsonIgnore
    private String password;
    @NotEmpty
    @Size(min = 10,max = 10, message = "Mobile no. must contain 10 digits ")
    private  String mobile;

}
