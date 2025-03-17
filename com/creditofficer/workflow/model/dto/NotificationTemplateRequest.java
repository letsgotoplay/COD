package com.creditofficer.workflow.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NotificationTemplateRequest {
    
    @NotBlank(message = "Template name is required")
    private String name;
    
    private String description;
    
    @NotBlank(message = "Template content is required")
    private String content;
}