package com.creditofficer.workflow.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalChainDefinition {
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private List<ApprovalStep> steps = new ArrayList<>();
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private List<ConditionalApproval> conditionalApprovals = new ArrayList<>();
}