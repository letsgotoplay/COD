package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.ApprovalChainDefinition;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkflowDefinitionDTO {
    
    private Long id;
    private String name;
    private String description;
    private FormDefinitionDTO formDefinition;
    private ApprovalChainDefinition approvalChainDefinition;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}