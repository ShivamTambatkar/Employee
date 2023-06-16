package com.humancloud.Employeemanagementsystem.Service.Impl;

import com.humancloud.Employeemanagementsystem.DTO.LeaveResponseDTO;
import com.humancloud.Employeemanagementsystem.DTO.LeavesDTO;
import com.humancloud.Employeemanagementsystem.Entity.Employee;
import com.humancloud.Employeemanagementsystem.Entity.LeaveStatus;
import com.humancloud.Employeemanagementsystem.Entity.Leaves;
import com.humancloud.Employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.humancloud.Employeemanagementsystem.Exceptions.UnauthorizedException;
import com.humancloud.Employeemanagementsystem.Repository.EmployeeRepository;
import com.humancloud.Employeemanagementsystem.Repository.LeavesRepository;
import com.humancloud.Employeemanagementsystem.Service.EmployeeService;
import com.humancloud.Employeemanagementsystem.Service.LeavesServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LeavesServiceImpl implements LeavesServices {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LeavesRepository leavesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createLeaves(Integer empId, LeavesDTO leavesDTO) {
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee", "empId", empId));
        Leaves leaves = modelMapper.map(leavesDTO, Leaves.class);
        leaves.setLeaveStatus(LeaveStatus.PENDING);
        leaves.setEmployee(employee);
        this.leavesRepository.save(leaves);
        return "leave applied Successfully";
    }

    @Override
    public String updateLeaves(Integer leavesId, LeavesDTO leavesDTO) {
        Leaves leaves = leavesRepository.findById(leavesId).orElseThrow(() -> new ResourceNotFoundException("Leave", "leaveId", leavesId));
        leaves.setId(leavesDTO.getId() != null ? leavesDTO.getId() : leaves.getId());
        leaves.setReasons(leavesDTO.getReasons() != null ? leavesDTO.getReasons() : leaves.getReasons());
        leaves.setStartDate(leavesDTO.getStartDate() != null ? leavesDTO.getStartDate() : leaves.getStartDate());
        leaves.setEndDate(leavesDTO.getEndDate() != null ? leavesDTO.getEndDate() : leaves.getEndDate());

        return "Leaves Updated Successfully";
    }

    @Override
    public List<LeaveResponseDTO> getAllLeaves() {
        List<Leaves> leavesList = leavesRepository.findAll();
        List<LeaveResponseDTO> leavesDTOS = leavesList.stream().map(leave -> modelMapper.map(leave, LeaveResponseDTO.class)).collect(Collectors.toList());
        return leavesDTOS;
    }

    @Override
    public LeaveResponseDTO getLeaveById(Integer leavesId) {
        Leaves leaves = leavesRepository.findById(leavesId).orElseThrow(() -> new ResourceNotFoundException("Leave", "leaveId", leavesId));
        LeaveResponseDTO leavesDTO = modelMapper.map(leaves, LeaveResponseDTO.class);
        return leavesDTO;


    }

    @Override
    public List<LeaveResponseDTO> getLeaveByUserID(Integer empId) {

        Employee employee = this.employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee", "empId", empId));
        List<Leaves> leavesList = this.leavesRepository.findByEmployee(employee);
        List<LeaveResponseDTO> leavesDTOS = leavesList.stream().map(leaves -> modelMapper.map(leaves, LeaveResponseDTO.class)).collect(Collectors.toList());
        return leavesDTOS;


    }

    @Override
    public String approveLeave(Integer leaveId, Integer reportingManagerId) {
        Leaves leave = this.leavesRepository.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("leave", "leaveId", leaveId));
        if (!leave.getEmployee().getReportingManager().getId().equals(reportingManagerId)) {
            throw new UnauthorizedException("reportingmanager", "ReportingManagerId", reportingManagerId);
        }
        leave.setLeaveStatus(LeaveStatus.APPROVED);
        Leaves savedleave = this.leavesRepository.save(leave);
        LeavesDTO leavesDTO = modelMapper.map(leave, LeavesDTO.class);

        return "LeaveApplication has been Approved";
    }

    @Override
    public String rejectLeave(Integer leaveId, Integer reportingManagerId) {
        Leaves leave = this.leavesRepository.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("leave", "leaveId", leaveId));
         if (!leave.getEmployee().getReportingManager().getId().equals(reportingManagerId)) {
            throw new UnauthorizedException("reportingmanager", "ReportingManagerId", reportingManagerId);
        }
        leave.setLeaveStatus(LeaveStatus.REJECT);
        Leaves savedleave = this.leavesRepository.save(leave);
        LeavesDTO leavesDTO = modelMapper.map(leave, LeavesDTO.class);

        return "Your LeaveApplication has been Rejected";
    }

    @Override
    public List<LeaveResponseDTO> getAllPendingLeavesOfEmployee(Integer empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("employee","empId",empId));
        List<Leaves> leavesList = leavesRepository.findByLeaveStatusAndEmployee(LeaveStatus.PENDING, employee);
        List<LeaveResponseDTO> leaveResponseDTOS = leavesList.stream().map(leave -> modelMapper.map(leave, LeaveResponseDTO.class)).collect(Collectors.toList());
        return leaveResponseDTOS;
    }

}
