package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView

object Display {

    private var currentExpression = "0"
    private var inputtedNumber = ""
    private var symbolPressed = false
    private var pendingSymbol: Char? = null

    fun handleButtonClick(button: Button, calculatorDisplay: TextView) {

        when (button.id) {
            R.id.clear -> {
                inputtedNumber = "0"
                symbolPressed = false
                showInputtedNumber(calculatorDisplay)
            }

            R.id.clearEntry -> {
                currentExpression = "0"
                inputtedNumber = ""
                symbolPressed = false
                showCurrentExpression(calculatorDisplay)
            }

            R.id.changeSymbol -> {
                inputtedNumber = Calculate.changeSymbol(inputtedNumber)
                showInputtedNumber(calculatorDisplay)
            }

            R.id.plus, R.id.minus, R.id.multiply, R.id.divide -> {
                if (symbolPressed) {
                    pendingSymbol = button.text.toString().first()
                } else {
                    currentExpression = if (pendingSymbol != null) {
                        Calculate.calculateExpression(
                            currentExpression,
                            inputtedNumber,
                            pendingSymbol!!
                        )
                    } else {
                        inputtedNumber
                    }
                    pendingSymbol = button.text.toString().first()
                    inputtedNumber = ""
                    symbolPressed = true
                    showCurrentExpression(calculatorDisplay)
                }
            }

            R.id.squareRoot -> {
                inputtedNumber = Calculate.squareRoot(inputtedNumber)
                showInputtedNumber(calculatorDisplay)
            }

            R.id.deleteSymbol -> {
                if (inputtedNumber.isNotEmpty()) {
                    inputtedNumber = inputtedNumber.substring(0, inputtedNumber.length - 1)
                    showInputtedNumber(calculatorDisplay)
                } else if (pendingSymbol != null) {
                    pendingSymbol = null
                    symbolPressed = false
                }
            }

            R.id.equal -> {
                if (symbolPressed && inputtedNumber.isNotEmpty() && pendingSymbol != null) {
                    currentExpression = Calculate.calculateExpression(
                        currentExpression,
                        inputtedNumber,
                        pendingSymbol!!
                    )
                    inputtedNumber = ""
                    symbolPressed = false
                    pendingSymbol = null
                    currentExpression = trimNumbers(currentExpression)
                    showCurrentExpression(calculatorDisplay)
                }
            }

            else -> {
                inputtedNumber += button.text.toString()
                inputtedNumber = trimNumbers(inputtedNumber)
                showInputtedNumber(calculatorDisplay)
            }
        }
    }

    private fun trimNumbers(input: String): String {
        // Trim numbers starting with 0 and ending with .0
        var trimmedInput = input
        if (input.startsWith("0")) {
            trimmedInput = input.substring(1)
        }
        if (input.endsWith(".0")) {
            trimmedInput = input.substring(0, input.length - 2)
        }
        return trimmedInput
    }

    private fun showCurrentExpression(calculatorDisplay: TextView) {
        calculatorDisplay.text = currentExpression
    }

    private fun showInputtedNumber(calculatorDisplay: TextView) {
        calculatorDisplay.text = inputtedNumber
    }
}
