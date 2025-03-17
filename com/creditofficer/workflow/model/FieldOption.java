package com.creditofficer.workflow.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldOption implements Serializable {
    
    private String value;
    private String label;
}