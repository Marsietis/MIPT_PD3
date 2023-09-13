package com.example.mipt_pd3

import kotlin.math.sqrt

object Calculate {
    fun changeSymbol(expression: String): String {
        return if (expression.startsWith("-")) {
            expression.substring(1)
        } else {
            "-$expression"
        }
    }

    fun plus(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() + inputtedNumber.toDouble()
        return result.toString()
    }

    fun minus(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() - inputtedNumber.toDouble()
        return result.toString()
    }

    fun multiply(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() * inputtedNumber.toDouble()
        return result.toString()
    }

    fun divide(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() / inputtedNumber.toDouble()
        return result.toString()
    }

    fun squareRoot(currentExpression: String): String {
        val result = sqrt(currentExpression.toDouble())
        return result.toString()
    }
}
