package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.ApprovalActionType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ApprovalActionRequest {
    
    @NotNull(message = "Action type is required")
    private ApprovalActionType action;
    
    private String comments;
    
    private String delegateUserId;
}