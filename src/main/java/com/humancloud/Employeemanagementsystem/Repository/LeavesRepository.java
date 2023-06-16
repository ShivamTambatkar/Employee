package com.humancloud.Employeemanagementsystem.Repository;

import com.humancloud.Employeemanagementsystem.Entity.Employee;
import com.humancloud.Employeemanagementsystem.Entity.LeaveStatus;
import com.humancloud.Employeemanagementsystem.Entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeavesRepository extends JpaRepository<Leaves,Integer> {
  List<Leaves> findByEmployee(Employee employee);

  List<Leaves> findByLeaveStatus(LeaveStatus leaveStatus);

  List<Leaves> findByLeaveStatusAndEmployee(LeaveStatus leaveStatus, Employee employee);



}
