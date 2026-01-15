package com.textbond.targetapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class RoleValidator implements ConstraintValidator<ValidRole, String> {

    private static final Set<String> ALLOWED_ROLES =
            Set.of("BUYER", "SELLER", "ADMIN");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return ALLOWED_ROLES.contains(value);
    }
}
