package com.example.mipt_pd3

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class CalculateTest {

    // changeSymbol tests
    @Test
    fun changeSymbol_PositiveInput_ReturnsNegativeInput() {
        val result = Calculate.changeSymbol("123")
        assertEquals("-123", result)
    }

    @Test
    fun changeSymbol_NegativeInput_ReturnsPositiveInput() {
        val result = Calculate.changeSymbol("-123")
        assertEquals("123", result)
    }

    @Test
    fun changeSymbol_zeroInput_ReturnsZeroInput() {
        val result = Calculate.changeSymbol("0")
        assertEquals("0", result)
    }

    @Test
    fun changeSymbol_emptyInput_ReturnsEmptyInput() {
        val result = Calculate.changeSymbol("")
        assertEquals("", result)
    }

    @Test
    fun changeSymbol_LargePositiveInput_ReturnsLargeNegativeInput() {
        val result = Calculate.changeSymbol("12345678901234567890")
        assertEquals("-12345678901234567890", result)
    }

    @Test
    fun changeSymbol_LargeNegativeInput_ReturnsLargePositiveInput() {
        val result = Calculate.changeSymbol("-12345678901234567890")
        assertEquals("12345678901234567890", result)
    }

    @Test
    fun changeSymbol_LargeZeroInput_ReturnsLargeNegativeZeroInput() {
        val result = Calculate.changeSymbol("00000000000000000000")
        assertEquals("-00000000000000000000", result)
    }

    @Test
    fun changeSymbol_NegativeZeroInput_ReturnsZero() {
        val result = Calculate.changeSymbol("-0")
        assertEquals("0", result)
    }

    // calculateExpression tests

    @Test
    fun calculateExpression_WithEmptyString_ThrowsIllegalArgumentException() {
        assertThrows<IllegalArgumentException> {
            Calculate.calculateExpression("", "123", '+')
        }

        assertThrows<IllegalArgumentException> {
            Calculate.calculateExpression("123", "", '+')
        }

        assertThrows<IllegalArgumentException> {
            Calculate.calculateExpression("", "", '+')
        }
    }

    // plus tests
    @Test
    fun calculateExpression_PlusPositivePositive_ReturnsPositive() {
        val result = Calculate.calculateExpression("15", "25", '+')
        assertEquals("40.0", result)
    }

    @Test
    fun calculateExpression_PlusPositiveNegative_ReturnsNegative() {
        val result = Calculate.calculateExpression("15", "-25", '+')
        assertEquals("-10.0", result)
    }

    @Test
    fun calculateExpression_PlusNegativeNegative_ReturnsNegative() {
        val result = Calculate.calculateExpression("-15", "-25", '+')
        assertEquals("-40.0", result)
    }

    @Test
    fun calculateExpression_PlusPositiveSameNegative_ReturnsZero() {
        val result = Calculate.calculateExpression("123", "-123", '+')
        assertEquals("0.0", result)
    }

    @Test
    fun calculateExpression_PlusZeroZero_ReturnsZero() {
        val result = Calculate.calculateExpression("0", "0", '+')
        assertEquals("0.0", result)
    }

    @Test
    fun calculateExpression_PlusLargePositiveLargePositive_ReturnsLargePositive() {
        val result =
            Calculate.calculateExpression("12345678901234567890", "12345678901234567890", '+')
        assertEquals("2.4691357802469134E19", result)
    }

    // minus tests
    @Test
    fun calculateExpression_MinusLargerPositiveSmallerPositive_ReturnsPositive() {
        val result = Calculate.calculateExpression("25", "15", '-')
        assertEquals("10.0", result)
    }

    @Test
    fun calculateExpression_MinusPositiveNegative_ReturnsPositive() {
        val result = Calculate.calculateExpression("15", "-25", '-')
        assertEquals("40.0", result)
    }

    @Test
    fun calculateExpression_MinusNegativeNegative_ReturnsNegative() {
        val result = Calculate.calculateExpression("-123", "-456", '-')
        assertEquals("333.0", result)
    }

    @Test
    fun calculateExpression_MinusPositiveSamePositive_ReturnsZero() {
        val result = Calculate.calculateExpression("123", "123", '-')
        assertEquals("0.0", result)
    }

    @Test
    fun calculateExpression_MinusZeroZero_ReturnsZero() {
        val result = Calculate.calculateExpression("0", "0", '-')
        assertEquals("0.0", result)
    }


    @Test
    fun calculateExpression_MinusLargePositiveSameLargePositive_ReturnsZero() {
        val result =
            Calculate.calculateExpression("12345678901234567890", "12345678901234567890", '-')
        assertEquals("0.0", result)
    }

    // multiply tests
    @Test
    fun calculateExpression_MultiplyPositivePositive_ReturnsPositive() {
        val result = Calculate.calculateExpression("15", "25", '*')
        assertEquals("375.0", result)
    }

    @Test
    fun calculateExpression_MultiplyPositiveNegative_ReturnsNegative() {
        val result = Calculate.calculateExpression("15", "-25", '*')
        assertEquals("-375.0", result)
    }

    @Test
    fun calculateExpression_MultiplyNegativeNegative_ReturnsPositive() {
        val result = Calculate.calculateExpression("-15", "-25", '*')
        assertEquals("375.0", result)
    }

    @Test
    fun calculateExpression_MultiplyByZero_ReturnsZero() {
        val result = Calculate.calculateExpression("15", "0", '*')
        assertEquals("0.0", result)
    }

    @Test
    fun calculateExpression_MultiplyZero_ReturnsZero() {
        val result = Calculate.calculateExpression("0", "15", '*')
        assertEquals("0.0", result)
    }

    // divide tests

    @Test
    fun calculateExpression_DividePositivePositive_ReturnsPositive() {
        val result = Calculate.calculateExpression("15", "25", '/')
        assertEquals("0.6", result)
    }

    @Test
    fun calculateExpression_DividePositiveNegative_ReturnsNegative() {
        val result = Calculate.calculateExpression("15", "-25", '/')
        assertEquals("-0.6", result)
    }

    @Test
    fun calculateExpression_DivideNegativeNegative_ReturnsPositive() {
        val result = Calculate.calculateExpression("-15", "-25", '/')
        assertEquals("0.6", result)
    }

    @Test
    fun calculateExpression_DivideByZero_ReturnsError() {
        val result = Calculate.calculateExpression("15", "0", '/')
        assertEquals("Error", result)
    }

    @Test
    fun calculateExpression_DivideZero_ReturnsZero() {
        val result = Calculate.calculateExpression("0", "15", '/')
        assertEquals("0.0", result)
    }

    // squareRoot tests

    @Test
    fun squareRoot_PositiveInput_ReturnsPositive() {
        val result = Calculate.squareRoot("25")
        assertEquals("5.0", result)
    }

    @Test
    fun squareRoot_PositiveInput_ReturnsPositiveLongerDouble() {
        val result = Calculate.squareRoot("123")
        assertEquals("11.090536506409418", result)
    }

    @Test
    fun squareRoot_NegativeInput_ReturnsError() {
        val result = Calculate.squareRoot("-25")
        assertEquals("Error", result)
    }

    @Test
    fun squareRoot_ZeroInput_ReturnsZero() {
        val result = Calculate.squareRoot("0")
        assertEquals("0.0", result)
    }
}
