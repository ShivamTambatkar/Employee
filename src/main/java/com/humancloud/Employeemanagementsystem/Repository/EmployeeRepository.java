package com.humancloud.Employeemanagementsystem.Repository;

import com.humancloud.Employeemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



    List<Employee>  findByNameContaining(String name);


    Optional<Employee> findByName(String username);

    Optional<Employee> findByEmail(String username);






    boolean existsByEmail(String email);
}
