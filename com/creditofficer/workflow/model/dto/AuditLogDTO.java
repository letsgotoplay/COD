package com.creditofficer.workflow.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogDTO {
    
    private Long id;
    private String action;
    private String entityType;
    private Long entityId;
    private String details;
    private String username;
    private String ipAddress;
    private LocalDateTime createdAt;
}