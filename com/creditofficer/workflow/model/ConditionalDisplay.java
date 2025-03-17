package com.creditofficer.workflow.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConditionalDisplay implements Serializable {
    
    private String condition;
    private String dependsOn;
    private String value;
}