package com.creditofficer.workflow.model.dto;

import com.creditofficer.workflow.model.ConditionalDisplay;
import com.creditofficer.workflow.model.FieldOption;
import com.creditofficer.workflow.model.ValidationRules;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FormFieldRequest {
    
    @NotBlank(message = "Field name is required")
    private String name;
    
    @NotBlank(message = "Field label is required")
    private String label;
    
    @NotBlank(message = "Field type is required")
    private String type;
    
    @NotNull(message = "Required flag must be specified")
    private boolean required;
    
    @NotNull(message = "Field order must be specified")
    private int order;
    
    private List<FieldOption> options;
    
    private ValidationRules validationRules;
    
    private ConditionalDisplay conditionalDisplay;
    
    private String defaultValue;
    
    private String placeholder;
    
    private String helpText;
}