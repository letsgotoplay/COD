@Component
public class AppointmentFormInitializer implements CommandLineRunner {

    @Autowired
    private FormDefinitionRepository formDefRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Check if appointment form already exists
        if (formDefRepository.findByNameAndWorkflowType("Credit Officer Appointment Form", "APPOINTMENT").isPresent()) {
            return;
        }
        
        // Create appointment form definition
        FormDefinition appointmentForm = new FormDefinition();
        appointmentForm.setName("Credit Officer Appointment Form");
        appointmentForm.setDescription("Form for appointing new Credit Officers");
        appointmentForm.setWorkflowType("APPOINTMENT");
        
        List<FormField> fields = new ArrayList<>();
        
        // Common fields
        fields.add(createField("employeeId", "Employee ID", "TEXT", true, 1));
        fields.add(createField("employeeName", "Employee Name", "TEXT", true, 2));
        fields.add(createField("department", "Department", "SELECT", true, 3, 
                Arrays.asList(
                    new FieldOption("corporate", "Corporate Banking"),
                    new FieldOption("retail", "Retail Banking"),
                    new FieldOption("investment", "Investment Banking"),
                    new FieldOption("risk", "Risk Management")
                )));
        fields.add(createField("currentPosition", "Current Position", "TEXT", true, 4));
        fields.add(createField("manager", "Manager", "TEXT", true, 5));
        
        // Appointment specific fields
        fields.add(createField("resume", "Resume/CV", "FILE", true, 6));
        fields.add(createField("education", "Education Background", "TEXTAREA", true, 7));
        fields.add(createField("certifications", "Professional Certifications", "TEXTAREA", false, 8));
        fields.add(createField("experience", "Years of Experience", "NUMBER", true, 9, null, 
                new ValidationRules(0, 50, null)));
        fields.add(createField("proposedPosition", "Proposed Position", "TEXT", true, 10));
        fields.add(createField("salaryBand", "Proposed Salary Band", "SELECT", true, 11,
                Arrays.asList(
                    new FieldOption("band1", "Band 1 (Junior)"),
                    new FieldOption("band2", "Band 2 (Mid-level)"),
                    new FieldOption("band3", "Band 3 (Senior)"),
                    new FieldOption("band4", "Band 4 (Executive)")
                )));
        fields.add(createField("startDate", "Start Date", "DATE", true, 12));
        fields.add(createField("probationPeriod", "Probation Period (months)", "NUMBER", true, 13, null,
                new ValidationRules(1, 12, null)));
        fields.add(createField("reportingStructure", "Reporting Structure", "TEXTAREA", true, 14));
        fields.add(createField("complianceCheck", "Compliance Check Results", "SELECT", true, 15,
                Arrays.asList(
                    new FieldOption("passed", "Passed"),
                    new FieldOption("pending", "Pending"),
                    new FieldOption("failed", "Failed")
                )));
        fields.add(createField("backgroundVerification", "Background Verification Status", "SELECT", true, 16,
                Arrays.asList(
                    new FieldOption("verified", "Verified"),
                    new FieldOption("inProgress", "In Progress"),
                    new FieldOption("issues", "Issues Found")
                )));
        fields.add(createField("supportingDocuments", "Supporting Documents", "FILE", false, 17));
        fields.add(createField("comments", "Comments/Justification", "TEXTAREA", false, 18));
        
        appointmentForm.setFields(fields);
        
        // Create form sections
        List<FormSection> sections = Arrays.asList(
            new FormSection("basicInfo", "Basic Information", Arrays.asList(0, 1, 2, 3, 4)),
            new FormSection("candidateInfo", "Candidate Information", Arrays.asList(5, 6, 7, 8)),
            new FormSection("positionDetails", "Position Details", Arrays.asList(9, 10, 11, 12, 13)),
            new FormSection("compliance", "Compliance & Verification", Arrays.asList(14, 15)),
            new FormSection("additional", "Additional Information", Arrays.asList(16, 17))
        );
        
        appointmentForm.setSections(sections);
        
        formDefRepository.save(appointmentForm);
    }
    
    private FormField createField(String name, String label, String type, boolean required, int order) {
        return createField(name, label, type, required, order, null, null);
    }
    
    private FormField createField(String name, String label, String type, boolean required, int order, 
                                 List<FieldOption> options) {
        return createField(name, label, type, required, order, options, null);
    }
    
    private FormField createField(String name, String label, String type, boolean required, int order,
                                 List<FieldOption> options, ValidationRules validationRules) {
        FormField field = new FormField();
        field.setName(name);
        field.setLabel(label);
        field.setType(type);
        field.setRequired(required);
        field.setOrder(order);
        field.setOptions(options);
        field.setValidationRules(validationRules);
        return field;
    }
}