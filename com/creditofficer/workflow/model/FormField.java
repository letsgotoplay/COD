package com.creditofficer.workflow.model;

import javax.persistence.*;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "form_fields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormField {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String label;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private boolean required;
    
    @Column(nullable = false)
    private int order;
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private List<FieldOption> options;
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private ValidationRules validationRules;
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private ConditionalDisplay conditionalDisplay;
    
    private String defaultValue;
    
    private String placeholder;
    
    private String helpText;
}