package com.creditofficer.workflow.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalStep implements Serializable {
    
    private String stepId;
    private String name;
    private ApproverType approverType;
    private String approverValue;
    private boolean mandatory;
    private int order;
    private Integer timeoutDays;
    private String escalationApprover;
}