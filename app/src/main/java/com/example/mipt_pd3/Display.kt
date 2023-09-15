package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView

object Display {

    private const val ERROR = "Error"

    private var currentExpression = "0"
    private var inputtedNumber = ""
    private var symbolPressed = false
    private var operatorPressed = false
    private var pendingSymbol: Char? = null

    fun handleButtonClick(button: Button, calculatorDisplay: TextView) {
        when (button.id) {
            R.id.clear -> clear()
            R.id.clearEntry -> clearEntry()
            R.id.deleteSymbol -> deleteSymbol()
            R.id.changeSymbol -> changeSymbol()
            R.id.plus, R.id.minus, R.id.multiply, R.id.divide -> arithmeticOperations(button)
            R.id.squareRoot -> squareRoot()
            R.id.equal -> equal()
            else -> getNumber(button.text.toString())
        }
        showOutput(calculatorDisplay)
    }

    private fun trimNumbers(input: String): String {
        var trimmedInput = input

        if (input.startsWith("0") && !input.startsWith("0.")) {
            trimmedInput = input.substring(1)
        }
        if (input.endsWith(".0")) {
            trimmedInput = input.substring(0, input.length - 2)
        }
        if (input.endsWith(".")) {
            trimmedInput = input.substring(0, input.length - 1)
        }
        if (input == "" || input == "-" || input == "0.") {
            trimmedInput = "0"
        }
        return trimmedInput
    }

    private fun showOutput(calculatorDisplay: TextView) {
        if (operatorPressed) {
            calculatorDisplay.text = currentExpression
        } else {
            calculatorDisplay.text = inputtedNumber
        }
    }

    private fun clear() {
        inputtedNumber = "0"
        symbolPressed = false
    }

    private fun clearEntry() {
        currentExpression = "0"
        inputtedNumber = "0"
        symbolPressed = false
    }

    private fun changeSymbol() {
        if (inputtedNumber != ERROR) {
            inputtedNumber = Calculate.changeSymbol(inputtedNumber)
        }
    }

    private fun squareRoot() {
        if (inputtedNumber != ERROR) {
            inputtedNumber = Calculate.squareRoot(inputtedNumber)
            inputtedNumber = trimNumbers(inputtedNumber)
        }
    }

    private fun deleteSymbol() {
        when {
            inputtedNumber == ERROR -> inputtedNumber = ""
            inputtedNumber.isNotEmpty() -> inputtedNumber =
                inputtedNumber.substring(0, inputtedNumber.length - 1)

            pendingSymbol != null -> {
                pendingSymbol = null
                symbolPressed = false
            }
        }
        inputtedNumber = trimNumbers(inputtedNumber)
    }

    private fun arithmeticOperations(button: Button) {
        if (inputtedNumber != ERROR) {
            if (symbolPressed) {
                pendingSymbol = button.text.toString().first()
            } else {
                handlePendingSymbol(button)
            }
            operatorPressed = true
        }
    }

    private fun handlePendingSymbol(button: Button) {
        currentExpression = if (pendingSymbol != null) {
            Calculate.calculateExpression(currentExpression, inputtedNumber, pendingSymbol!!)
        } else {
            inputtedNumber
        }
        pendingSymbol = button.text.toString().first()
        inputtedNumber = ""
        symbolPressed = true
        inputtedNumber = trimNumbers(inputtedNumber)
    }

    private fun equal() {
        if (inputtedNumber != ERROR && symbolPressed && inputtedNumber.isNotEmpty() && pendingSymbol != null) {
            currentExpression =
                Calculate.calculateExpression(currentExpression, inputtedNumber, pendingSymbol!!)
            inputtedNumber = ""
            symbolPressed = false
            pendingSymbol = null
            currentExpression = trimNumbers(currentExpression)
            inputtedNumber = currentExpression
        }
        operatorPressed = false
    }

    private fun getNumber(number: String) {
        if (inputtedNumber != ERROR) {
            inputtedNumber += number
            inputtedNumber = trimNumbers(inputtedNumber)
            operatorPressed = false
        }
    }
}
