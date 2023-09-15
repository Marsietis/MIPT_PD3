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
        currentExpression: String, inputtedNumber: String, pendingSymbol: Char
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
        return (currentExpression.toDouble() + inputtedNumber.toDouble()).toString()
    }

    private fun minus(currentExpression: String, inputtedNumber: String): String {
        return (currentExpression.toDouble() - inputtedNumber.toDouble()).toString()
    }

    private fun multiply(currentExpression: String, inputtedNumber: String): String {
        return (currentExpression.toDouble() * inputtedNumber.toDouble()).toString()
    }

    private fun divide(currentExpression: String, inputtedNumber: String): String {
        return if (inputtedNumber.toDouble() != 0.0) {
            (currentExpression.toDouble() / inputtedNumber.toDouble()).toString()
        } else {
            "Error"
        }
    }

    fun squareRoot(inputtedNumber: String): String {
        return if (!inputtedNumber.startsWith("-")) {
            sqrt(inputtedNumber.toDouble()).toString()
        } else {
            "Error"
        }
    }
}