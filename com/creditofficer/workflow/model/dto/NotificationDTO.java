package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.NotificationType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    
    private Long id;
    private NotificationType type;
    private String title;
    private String message;
    private Long workflowId;
    private boolean read;
    private LocalDateTime createdAt;
}