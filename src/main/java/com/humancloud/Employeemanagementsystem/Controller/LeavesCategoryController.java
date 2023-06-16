package com.humancloud.Employeemanagementsystem.Controller;

import com.humancloud.Employeemanagementsystem.DTO.LeaveCategoryDTO;
import com.humancloud.Employeemanagementsystem.Service.LeaveCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lc")
@Tag(name = "Leave-Category")
public class LeavesCategoryController {
    @Autowired
    private LeaveCategoryService leaveCategoryService;


    @PostMapping("/create-leavecategory")
    public ResponseEntity<String> createLeaveCategory (@RequestBody LeaveCategoryDTO leaveCategoryDTO){
        String leaveCategory = this.leaveCategoryService.createLeaveCategory(leaveCategoryDTO);
        return  new ResponseEntity<String>(leaveCategory,HttpStatus.CREATED);
    }

    @PutMapping ("/update-leavecategory/{lcId}")
    public ResponseEntity<String> updateLeaveCategory (@RequestBody LeaveCategoryDTO leaveCategoryDTO, @PathVariable Integer lcId){
        String leaveCategory = this.leaveCategoryService.updateLeaveCategory(leaveCategoryDTO,lcId);
        return  new ResponseEntity<String>(leaveCategory,HttpStatus.CREATED);
    }
    @GetMapping("/getall-leavecategories")
    public ResponseEntity<List<LeaveCategoryDTO>>getAllLeaveCategory(){
        List<LeaveCategoryDTO> allLeaveCategory = this.leaveCategoryService.getAllLeaveCategory();
        return ResponseEntity.ok(allLeaveCategory);
    }

    @GetMapping("/getleavecategory/{lcId}")
    public ResponseEntity<LeaveCategoryDTO> getSingleLeaveCategory(@PathVariable Integer lcId){
        LeaveCategoryDTO leaveCategoryById = this.leaveCategoryService.getLeaveCategoryById(lcId);
        return ResponseEntity.ok(leaveCategoryById);
    }
    @DeleteMapping("deletelc/{lcId}")
    public  ResponseEntity<String> deleteLeaveCategory(@PathVariable Integer lcId){
        String deleteLeaveCategory = this.leaveCategoryService.deleteLeaveCategory(lcId);
        return ResponseEntity.ok(deleteLeaveCategory);
    }
}
