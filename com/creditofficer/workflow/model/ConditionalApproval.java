package com.creditofficer.workflow.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConditionalApproval implements Serializable {
    
    private String id;
    private String description;
    private String condition;
    private List<ApprovalStep> additionalApprovers = new ArrayList<>();
    private boolean skipDefaultApprovers;
}