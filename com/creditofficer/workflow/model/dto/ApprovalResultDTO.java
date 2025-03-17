package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.ApprovalActionType;
import com.creditofficer.workflow.model.WorkflowStatus;
import lombok.Data;

@Data
public class ApprovalResultDTO {
    
    private Long workflowId;
    private ApprovalActionType action;
    private WorkflowStatus nextStatus;
    private String message;
}