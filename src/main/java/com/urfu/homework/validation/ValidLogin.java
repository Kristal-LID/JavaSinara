package com.urfu.homework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;
import java.lang.annotation.*;

@Size(min = 4, max = 20, message = "{validation.login.size}")
@NoSpecialChars(message = "{validation.login.specialChars}")
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLogin {
    String message() default "{validation.login.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}