package com.creditofficer.workflow.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "workflows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workflow {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "workflow_definition_id", nullable = false)
    private WorkflowDefinition workflowDefinition;
    
    @ManyToOne
    @JoinColumn(name = "credit_officer_id", nullable = false)
    private CreditOfficer creditOfficer;
    
    @ManyToOne
    @JoinColumn(name = "initiator_id", nullable = false)
    private User initiator;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_submission_id")
    private FormSubmission formSubmission;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkflowStatus status;
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private ApprovalStep currentApprovalStep;
    
    @ManyToMany
    @JoinTable(
        name = "workflow_current_approvers",
        joinColumns = @JoinColumn(name = "workflow_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> currentApprovers = new ArrayList<>();
    
    private boolean escalated = false;
    
    private boolean enhancedDueDiligence = false;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    private LocalDateTime submittedAt;
    
    private LocalDateTime completedAt;
}