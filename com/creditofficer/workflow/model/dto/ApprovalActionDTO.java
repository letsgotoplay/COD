package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.ApprovalActionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApprovalActionDTO {
    
    private Long id;
    private Long workflowId;
    private String approverName;
    private ApprovalActionType action;
    private String comments;
    private LocalDateTime createdAt;
}