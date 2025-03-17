package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.FormField;
import com.creditofficer.workflow.model.FormSection;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FormDefinitionDTO {
    
    private Long id;
    private String name;
    private String description;
    private List<FormField> fields;
    private List<FormSection> sections;
    private String workflowType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}