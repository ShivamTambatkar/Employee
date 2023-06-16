package com.humancloud.Employeemanagementsystem.Repository;

import com.humancloud.Employeemanagementsystem.Entity.LeaveCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesCategoryRepository extends JpaRepository<LeaveCategory,Integer> {

}
