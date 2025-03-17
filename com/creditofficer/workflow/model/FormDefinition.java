package com.creditofficer.workflow.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "form_definitions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDefinition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "form_definition_id")
    @OrderBy("order ASC")
    private List<FormField> fields = new ArrayList<>();
    
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private List<FormSection> sections;
    
    @Column(nullable = false)
    private String workflowType;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}