package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.FormSection;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FormDefinitionRequest {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    @NotBlank(message = "Workflow type is required")
    private String workflowType;
    
    @NotEmpty(message = "Form fields are required")
    private List<FormFieldRequest> fields;
    
    private List<FormSection> sections;
}