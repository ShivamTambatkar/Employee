package com.humancloud.Employeemanagementsystem.Repository;

import com.humancloud.Employeemanagementsystem.Entity.Employee_Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<Employee_Profile,Integer> {
}
