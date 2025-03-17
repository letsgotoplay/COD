package com.creditofficer.workflow.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PendingApprovalDTO {
    
    private Long workflowId;
    private String workflowType;
    private Long creditOfficerId;
    private String creditOfficerName;
    private String initiatorName;
    private LocalDateTime submittedAt;
    private String currentApprovalStep;
}