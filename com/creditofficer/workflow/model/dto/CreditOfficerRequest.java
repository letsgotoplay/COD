package com.creditofficer.workflow.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreditOfficerRequest {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Employee ID is required")
    private String employeeId;
    
    @NotBlank(message = "Department is required")
    private String department;
    
    @NotBlank(message = "Position is required")
    private String position;
    
    @NotBlank(message = "Level is required")
    private String level;
    
    private String region;
    
    private String branch;
    
    @NotNull(message = "Appointment date is required")
    private LocalDate appointmentDate;
    
    private Double loanApprovalLimit;
    
    private String riskLevel;
    
    private String userId;
}