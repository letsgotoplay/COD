package com.creditofficer.workflow.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
public class WorkflowSubmissionRequest {
    
    @NotNull(message = "Workflow definition ID is required")
    private Long workflowDefinitionId;
    
    @NotNull(message = "Credit officer ID is required")
    private Long creditOfficerId;
    
    @NotNull(message = "Form data is required")
    private Map<String, Object> formData = new HashMap<>();
}