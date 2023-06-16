package com.humancloud.Employeemanagementsystem.Service.Impl;

import com.humancloud.Employeemanagementsystem.DTO.LeaveCategoryDTO;
import com.humancloud.Employeemanagementsystem.Entity.LeaveCategory;
import com.humancloud.Employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.humancloud.Employeemanagementsystem.Repository.LeavesCategoryRepository;
import com.humancloud.Employeemanagementsystem.Service.LeaveCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeaveCategoryServiceImpl implements LeaveCategoryService {
    @Autowired
     private LeavesCategoryRepository leavesCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String createLeaveCategory(LeaveCategoryDTO leaveCategoryDTO) {

        LeaveCategory leaveCategory = modelMapper.map(leaveCategoryDTO, LeaveCategory.class);
        this.leavesCategoryRepository.save(leaveCategory);
        return "Created";


    }

    @Override
    public String updateLeaveCategory(LeaveCategoryDTO leaveCategoryDTO,Integer lcId) {
       LeaveCategory leavesCategory = this.leavesCategoryRepository.findById(lcId).orElseThrow(()-> new ResourceNotFoundException("LeaveCategory","lcId",lcId));
       leavesCategory.setId(leaveCategoryDTO.getId()!=null ?leaveCategoryDTO.getId():leavesCategory.getId());
       leavesCategory.setCategoryName(leaveCategoryDTO.getCategoryName()!=null ? leaveCategoryDTO.getCategoryName():leavesCategory.getCategoryName());
       this.leavesCategoryRepository.save(leavesCategory);
       return "Leave Category Successfully updated";
    }

    @Override
    public List<LeaveCategoryDTO> getAllLeaveCategory() {
        List<LeaveCategory> categoryList = this.leavesCategoryRepository.findAll();
        List<LeaveCategoryDTO> leaveCategoryDTOS = categoryList.stream().map(leaveCategory -> modelMapper.map(leaveCategory, LeaveCategoryDTO.class)).collect(Collectors.toList());
        return leaveCategoryDTOS;
    }

    @Override
    public LeaveCategoryDTO getLeaveCategoryById(Integer lcId) {
        LeaveCategory leaveCategory = this.leavesCategoryRepository.findById(lcId).orElseThrow(()->new ResourceNotFoundException("LeaveCategory","lcId",lcId));
      return  modelMapper.map(leaveCategory,LeaveCategoryDTO.class);

    }

    @Override
    public String deleteLeaveCategory(Integer lcId) {
        this.leavesCategoryRepository.deleteById(lcId);
        return "Leave Category Deleted Succesfully";
    }


}
