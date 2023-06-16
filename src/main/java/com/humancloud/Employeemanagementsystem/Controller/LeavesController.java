package com.humancloud.Employeemanagementsystem.Controller;

import com.humancloud.Employeemanagementsystem.DTO.LeaveResponseDTO;
import com.humancloud.Employeemanagementsystem.DTO.LeavesDTO;
import com.humancloud.Employeemanagementsystem.Service.LeavesServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
@Tag(name = "Leaves")
public class LeavesController {
    @Autowired
    private LeavesServices leavesServices;



    @Operation(
            description = "Get endpoint for Admin",
            summary = "This is a summery for management get endpoint",
            responses ={
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized/Invalid token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping("/getall-leaves")
    public ResponseEntity<List<LeaveResponseDTO>> getAllLeaves(){
        List<LeaveResponseDTO> allLeaves = this.leavesServices.getAllLeaves();
        return new ResponseEntity<List<LeaveResponseDTO>>(allLeaves, HttpStatus.OK);

    }
    @Operation(
            description = "Get endpoint for Employee",
            summary = "This is a summery for Employee get endpoint",
            responses ={
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized/Invalid token",
                            responseCode = "403"
                    )
            }
    )@GetMapping("/leave/{leaveId}")
    public  ResponseEntity<LeaveResponseDTO> getLeaveById(@PathVariable Integer leaveId){
        LeaveResponseDTO leaveById = this.leavesServices.getLeaveById(leaveId);
        return  ResponseEntity.ok(leaveById);

    }




    @PutMapping("/update-leave/{leaveId}")
    public ResponseEntity<String> updateLeaveApplication(@PathVariable Integer leaveId, @RequestBody LeavesDTO leavesDTO) {
        String updateLeaves = this.leavesServices.updateLeaves(leaveId, leavesDTO);
        return new ResponseEntity<>(updateLeaves, HttpStatus.OK);

    }


    @GetMapping("/pending-leaves/{empId}")
    public  ResponseEntity<List<LeaveResponseDTO>> getPendingLeavesOfEmployee(@PathVariable Integer empId){
        List<LeaveResponseDTO> allPendingLeavesOfEmployee = this.leavesServices.getAllPendingLeavesOfEmployee(empId);
        return ResponseEntity.ok(allPendingLeavesOfEmployee);
    }

    @GetMapping("/leaves/{empId}")
    public ResponseEntity<List<LeaveResponseDTO>> getallEmployeeLeaves(@PathVariable Integer empId) {
        List<LeaveResponseDTO> leaveByUserID = this.leavesServices.getLeaveByUserID(empId);
        return ResponseEntity.ok(leaveByUserID);

    }

    @PostMapping("/apply-leave/{empId}")
    public ResponseEntity<String> applyLeaves(@PathVariable Integer empId, @RequestBody LeavesDTO leavesDTO) {
        String leavesDto = this.leavesServices.createLeaves(empId, leavesDTO);
        return new ResponseEntity<>(leavesDto, HttpStatus.CREATED);
    }

    @PutMapping("/approve-leave/leave/{leaveId}/manager/{reportingManagerId}")
    public ResponseEntity<String> approveLeave(@PathVariable Integer leaveId, @PathVariable Integer reportingManagerId){
        String leavesDTO = this.leavesServices.approveLeave(leaveId, reportingManagerId);
        return new ResponseEntity<String>(leavesDTO, HttpStatus.ACCEPTED);
    }
    @PutMapping("/reject-leave/leave/{leaveId}/manager/{reportingManagerId}")
    public ResponseEntity<String> rejectLeave(@PathVariable Integer leaveId, @PathVariable Integer reportingManagerId){
        String leavesDTO = this.leavesServices.rejectLeave(leaveId, reportingManagerId);
        return new ResponseEntity<String>(leavesDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/pending-leaves-requests/{reportingMangerId}")
    public  ResponseEntity<List<LeaveResponseDTO>> leaveApprovalRequestsToManager(@PathVariable Integer reportingMangerId){
        List<LeaveResponseDTO> allPendingLeavesOfEmployee = this.leavesServices.getAllPendingLeavesOfEmployee(reportingMangerId);
        return ResponseEntity.ok(allPendingLeavesOfEmployee);
    }

}
