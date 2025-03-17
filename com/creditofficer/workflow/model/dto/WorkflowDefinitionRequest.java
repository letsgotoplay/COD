package com.creditofficer.workflow.model.dto;


import com.creditofficer.workflow.model.ApprovalStep;
import com.creditofficer.workflow.model.ConditionalApproval;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class WorkflowDefinitionRequest {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    @NotNull(message = "Form definition ID is required")
    private Long formDefinitionId;
    
    @NotNull(message = "Approval steps are required")
    private List<ApprovalStep> approvalSteps;
    
    private List<ConditionalApproval> conditionalApprovals;
}