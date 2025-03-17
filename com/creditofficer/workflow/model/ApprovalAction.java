package com.creditofficer.workflow.model;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "approval_actions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalAction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "workflow_id", nullable = false)
    private Workflow workflow;
    
    @ManyToOne
    @JoinColumn(name = "approver_id", nullable = false)
    private User approver;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalActionType action;
    
    private String comments;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
}