package com.creditofficer.workflow.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationTemplateDTO {
    
    private Long id;
    private String name;
    private String description;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}