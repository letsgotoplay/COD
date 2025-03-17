package com.creditofficer.workflow.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowState implements Serializable {
    
    private String name;
    private String description;
}