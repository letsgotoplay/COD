package com.creditofficer.workflow.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormSection implements Serializable {
    
    private String id;
    private String title;
    private List<Integer> fieldIndexes;
    private boolean collapsed = false;
}