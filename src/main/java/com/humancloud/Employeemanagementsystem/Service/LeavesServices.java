package com.humancloud.Employeemanagementsystem.Service;

import com.humancloud.Employeemanagementsystem.DTO.LeaveResponseDTO;
import com.humancloud.Employeemanagementsystem.DTO.LeavesDTO;

import java.util.List;

public interface LeavesServices {
   String createLeaves(Integer empId,LeavesDTO leavesDTO);
   String updateLeaves(Integer leavesId,LeavesDTO leavesDTO);
   List<LeaveResponseDTO> getAllLeaves();
   LeaveResponseDTO getLeaveById(Integer leaveId);
   List<LeaveResponseDTO>getLeaveByUserID(Integer empId);
  String approveLeave(Integer leaveId,Integer managerId);
  String  rejectLeave(Integer leaveId,Integer managerId);

  List<LeaveResponseDTO> getAllPendingLeavesOfEmployee(Integer empId);



}
