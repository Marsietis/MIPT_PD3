package com.example.mipt_pd3

import kotlin.math.sqrt

object Calculate {
    fun changeSymbol(inputtedNumber: String): String {
        if (inputtedNumber == "0" || inputtedNumber == "") {
            return inputtedNumber
        }
        return if (inputtedNumber.startsWith("-")) {
            inputtedNumber.substring(1)
        } else {
            "-$inputtedNumber"
        }

    }

    fun calculateExpression(
        currentExpression: String,
        inputtedNumber: String,
        pendingSymbol: Char
    ): String {
        return when (pendingSymbol) {
            '+' -> plus(currentExpression, inputtedNumber)
            '-' -> minus(currentExpression, inputtedNumber)
            '*' -> multiply(currentExpression, inputtedNumber)
            '/' -> divide(currentExpression, inputtedNumber)
            else -> currentExpression
        }
    }

    private fun plus(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() + inputtedNumber.toDouble()
        return result.toString()
    }

    private fun minus(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() - inputtedNumber.toDouble()
        return result.toString()
    }

    private fun multiply(currentExpression: String, inputtedNumber: String): String {
        val result = currentExpression.toDouble() * inputtedNumber.toDouble()
        return result.toString()
    }

    private fun divide(currentExpression: String, inputtedNumber: String): String {
        try {
            val numerator = currentExpression.toDouble()
            val denominator = inputtedNumber.toDouble()

            if (denominator == 0.0) {
                return "Error"
            }

            val result = numerator / denominator
            return result.toString()
        } catch (e: NumberFormatException) {
            return "Error"
        }
    }

    fun squareRoot(inputtedNumber: String): String {
        return try {
            val result = sqrt(inputtedNumber.toDouble())
            result.toString()
        } catch (e: NumberFormatException) {
            "Error"
        }
    }
}
