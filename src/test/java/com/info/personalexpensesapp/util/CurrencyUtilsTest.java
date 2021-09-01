package com.info.personalexpensesapp.util;

import org.junit.jupiter.api.Test;
import java.text.DecimalFormatSymbols;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyUtilsTest {

    @Test
    void givenCurrencyCode_whenCheckingContains_thenReturnTrue() {
        String currencyCode = "UAH";
        boolean result = CurrencyUtils.containsCurrencyCode(currencyCode);
        assertTrue(result);
    }

    @Test
    void givenCurrencyCode_whenCheckingContains_thenReturnFalse() {
        String currencyCode = "UA";
        boolean result = CurrencyUtils.containsCurrencyCode(currencyCode);
        assertFalse(result);
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
    }

    @Test
    void givenDecimalFormatSymbol_whenCreatingCustomDecimalDotFormat_thenReturnDotDecimalSeparator() {
        DecimalFormatSymbols decimalFormatSymbols;
        decimalFormatSymbols = CurrencyUtils.customCurrencyDecimalDotFormat().getDecimalFormatSymbols();
        assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    }
}