package com.platform.code_up.validations;

import com.platform.code_up.annotations.PasswordMatcher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements
        ConstraintValidator<PasswordMatcher,Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(PasswordMatcher constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);

        if (fieldValue != null && !fieldValue.equals(fieldMatchValue)) {
            // Add the error explicitly to the context
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode(fieldMatch)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
