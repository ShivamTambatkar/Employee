package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class Address {
    @Column(name = "address",nullable = false,length = 100)
    private String address;
    @NotEmpty
    private String city;
    @NotEmpty
    private String State;
    @NotEmpty
    private  Integer pincode;
}
