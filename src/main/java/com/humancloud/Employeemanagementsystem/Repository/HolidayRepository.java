package com.humancloud.Employeemanagementsystem.Repository;

import com.humancloud.Employeemanagementsystem.Entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
