package com.urfu.homework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoSpecialCharsValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSpecialChars {
    String message() default "{validation.noSpecialChars}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
