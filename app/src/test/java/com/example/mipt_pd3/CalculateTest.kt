package com.example.mipt_pd3

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateTest {

    @Test
    fun changeSymbol_positiveInput() {
        val result = Calculate.changeSymbol("123")
        assertEquals("-123", result)
    }

    @Test
    fun changeSymbol_negativeInput() {
        val result = Calculate.changeSymbol("-123")
        assertEquals("123", result)
    }

    @Test
    fun changeSymbol_emptyInput() {
        val result = Calculate.changeSymbol("")
        assertEquals("", result)
    }

    @Test
    fun calculateExpression_addition() {
        val result = Calculate.calculateExpression("10", "5", '+')
        assertEquals("15.0", result)
    }

    @Test
    fun calculateExpression_subtraction() {
        val result = Calculate.calculateExpression("10", "5", '-')
        assertEquals("5.0", result)
    }

    @Test
    fun calculateExpression_multiplication() {
        val result = Calculate.calculateExpression("10", "5", '*')
        assertEquals("50.0", result)
    }

    @Test
    fun calculateExpression_division() {
        val result = Calculate.calculateExpression("10", "5", '/')
        assertEquals("2.0", result)
    }

    @Test
    fun calculateExpression_divisionByZero() {
        val result = Calculate.calculateExpression("10", "0", '/')
        assertEquals("Error", result)
    }

    @Test
    fun squareRoot_positiveInput() {
        val result = Calculate.squareRoot("25")
        assertEquals("5.0", result)
    }

    @Test
    fun squareRoot_invalidInput() {
        val result = Calculate.squareRoot("-5")
        assertEquals("Error", result)
    }
}
