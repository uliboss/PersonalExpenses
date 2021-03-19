package com.info.personalexpensesapp.validation;

import com.info.personalexpensesapp.util.CurrencyUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyValidator implements ConstraintValidator<IsValidCurrency, String> {

    @Override
    public void initialize(IsValidCurrency constraintAnnotation) {
    }

    @Override
    public boolean isValid(String currencyField, ConstraintValidatorContext constraintValidatorContext) {
        return CurrencyUtils.containsCurrencyCode(currencyField);
    }
}
