package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.CreditOfficerStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditOfficerDTO {
    
    private Long id;
    private String name;
    private String employeeId;
    private String department;
    private String position;
    private String level;
    private String region;
    private String branch;
    private LocalDate appointmentDate;
    private LocalDate elevationDate;
    private LocalDate inactivationDate;
    private LocalDate deactivationDate;
    private CreditOfficerStatus status;
    private Double loanApprovalLimit;
    private String riskLevel;
    private String userId;
}