package com.creditofficer.workflow.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationRules implements Serializable {
    
    private Integer minValue;
    private Integer maxValue;
    private String regex;
    private Integer minLength;
    private Integer maxLength;
    private String customValidator;
}