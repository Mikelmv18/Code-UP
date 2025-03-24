package com.platform.code_up.annotations;

import com.platform.code_up.validations.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = FieldsValueMatchValidator.class)
public @interface PasswordMatcher {

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String message() default "Passwords do not match";

    String field();

    String fieldMatch();
}
