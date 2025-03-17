
package com.creditofficer.workflow.model;

public enum NotificationType {
    WORKFLOW_INITIATED("New workflow initiated"),
    PENDING_APPROVAL("Pending approval task"),
    APPROVAL_COMPLETED("Approval action taken"),
    WORKFLOW_STATUS_CHANGE("Workflow status change"),
    APPROACHING_DEADLINE("Approaching deadline"),
    ESCALATION("Escalation notification"),
    SYSTEM("System notification");
    
    private final String description;
    
    NotificationType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}