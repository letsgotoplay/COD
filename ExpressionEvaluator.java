package com.creditofficer.workflow.service;

import com.creditofficer.workflow.model.FormSubmission;
import com.creditofficer.workflow.model.Workflow;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Service for evaluating expressions in workflow conditions
 * Uses Spring Expression Language (SpEL) for dynamic evaluation
 */
@Component
public class ExpressionEvaluator {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Evaluates a string expression and returns the result as a string
     * 
     * @param expressionString The expression to evaluate
     * @param workflow The workflow context for the evaluation
     * @return The result of the expression as a string
     */
    public String evaluate(String expressionString, Workflow workflow) {
        if (expressionString == null || expressionString.trim().isEmpty()) {
            return null;
        }
        
        try {
            EvaluationContext context = createEvaluationContext(workflow);
            Expression expression = parser.parseExpression(expressionString);
            Object result = expression.getValue(context);
            
            return result != null ? result.toString() : null;
        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error evaluating expression: " + expressionString, e);
        }
    }

    /**
     * Evaluates a boolean expression
     * 
     * @param expressionString The expression to evaluate
     * @param workflow The workflow context for the evaluation
     * @return The result of the expression as a boolean
     */
    public boolean evaluateBoolean(String expressionString, Workflow workflow) {
        if (expressionString == null || expressionString.trim().isEmpty()) {
            return false;
        }
        
        try {
            EvaluationContext context = createEvaluationContext(workflow);
            Expression expression = parser.parseExpression(expressionString);
            Boolean result = expression.getValue(context, Boolean.class);
            
            return result != null && result;
        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error evaluating boolean expression: " + expressionString, e);
        }
    }

    /**
     * Evaluates a numeric expression
     * 
     * @param expressionString The expression to evaluate
     * @param workflow The workflow context for the evaluation
     * @return The result of the expression as a BigDecimal
     */
    public BigDecimal evaluateNumeric(String expressionString, Workflow workflow) {
        if (expressionString == null || expressionString.trim().isEmpty()) {
            return BigDecimal.ZERO;
        }
        
        try {
            EvaluationContext context = createEvaluationContext(workflow);
            Expression expression = parser.parseExpression(expressionString);
            Object result = expression.getValue(context);
            
            if (result == null) {
                return BigDecimal.ZERO;
            }
            
            if (result instanceof Number) {
                return new BigDecimal(result.toString());
            }
            
            return new BigDecimal(result.toString());
        } catch (Exception e) {
            throw new ExpressionEvaluationException("Error evaluating numeric expression: " + expressionString, e);
        }
    }

    /**
     * Creates an evaluation context with workflow data
     * 
     * @param workflow The workflow to use for context
     * @return The evaluation context
     */
    private EvaluationContext createEvaluationContext(Workflow workflow) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        
        // Add workflow object
        context.setVariable("workflow", workflow);
        
        // Add credit officer details
        if (workflow.getCreditOfficer() != null) {
            context.setVariable("creditOfficer", workflow.getCreditOfficer());
        }
        
        // Add form data
        FormSubmission formSubmission = workflow.getFormSubmission();
        if (formSubmission != null && formSubmission.getFormData() != null) {
            Map<String, Object> formData = formSubmission.getFormData();
            
            // Add all form fields directly as variables
            for (Map.Entry<String, Object> entry : formData.entrySet()) {
                context.setVariable(entry.getKey(), entry.getValue());
            }
            
            // Also add the entire form data map
            context.setVariable("formData", formData);
        }
        
        // Add workflow metadata
        context.setVariable("workflowType", workflow.getWorkflowDefinition().getName());
        context.setVariable("initiator", workflow.getInitiator());
        context.setVariable("status", workflow.getStatus());
        
        return context;
    }
    
    /**
     * Custom exception for expression evaluation errors
     */
    public static class ExpressionEvaluationException extends RuntimeException {
        public ExpressionEvaluationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}