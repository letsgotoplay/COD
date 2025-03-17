package com.creditofficer.workflow.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "credit_officers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditOfficer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String employeeId;
    
    @Column(nullable = false)
    private String department;
    
    @Column(nullable = false)
    private String position;
    
    @Column(nullable = false)
    private String level;
    
    private String region;
    
    private String branch;
    
    @Column(nullable = false)
    private LocalDate appointmentDate;
    
    private LocalDate elevationDate;
    
    private LocalDate inactivationDate;
    
    private LocalDate deactivationDate;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditOfficerStatus status;
    
    private Double loanApprovalLimit;
    
    private String riskLevel;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}