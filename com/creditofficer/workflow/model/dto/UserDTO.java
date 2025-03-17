package com.creditofficer.workflow.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserDTO {
    
    private String id;
    private String name;
    private String username;
    private String email;
    private String department;
    private String position;
    private Integer yearsOfExperience;
    private String phoneNumber;
    private boolean active;
    private Set<String> roles;
    private LocalDateTime createdAt;
}