package com.urfu.homework.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoSpecialCharsValidator implements ConstraintValidator<NoSpecialChars, String> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (!value.matches("^[a-zA-Zа-яА-ЯёЁ0-9 ]+$")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Обнаружены спецсимволы в '" + value + "'. Допустимы только буквы и цифры"
            ).addConstraintViolation();
            return false;
        }
        return true;
    }
}