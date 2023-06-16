package com.humancloud.Employeemanagementsystem.Service;

import com.humancloud.Employeemanagementsystem.DTO.LeaveCategoryDTO;
import com.humancloud.Employeemanagementsystem.Entity.LeaveCategory;

import java.util.List;


public interface LeaveCategoryService {

    String createLeaveCategory(LeaveCategoryDTO leaveCategoryDTO);
    String updateLeaveCategory(LeaveCategoryDTO leaveCategoryDTO,Integer lcId);
    List<LeaveCategoryDTO> getAllLeaveCategory();

    LeaveCategoryDTO getLeaveCategoryById(Integer lcId);

    String deleteLeaveCategory(Integer lcId);



}
