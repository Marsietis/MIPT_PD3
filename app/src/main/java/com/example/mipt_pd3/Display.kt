package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView

object Display {

    private var currentExpression = "0"
    private var inputtedNumber = ""

    fun handleButtonClick(button: Button, calculatorDisplay: TextView) {

        when (button.id) {
            R.id.clear -> {
                currentExpression = "0"
                inputtedNumber = ""
                showCurrentExpression(calculatorDisplay)
            }

            R.id.clearEntry -> {
                inputtedNumber = ""
                showInputtedNumber(calculatorDisplay)
            }

            R.id.changeSymbol -> {
                inputtedNumber = Calculate.changeSymbol(inputtedNumber)
                showInputtedNumber(calculatorDisplay)
            }

            R.id.plus -> {
                currentExpression = Calculate.plus(currentExpression, inputtedNumber)
                showCurrentExpression(calculatorDisplay)
            }

            R.id.minus -> {
                currentExpression = Calculate.minus(currentExpression, inputtedNumber)
                showCurrentExpression(calculatorDisplay)
            }

            R.id.multiply -> {
                currentExpression = Calculate.multiply(currentExpression, inputtedNumber)
                showCurrentExpression(calculatorDisplay)
            }

            R.id.divide -> {
                currentExpression = Calculate.divide(currentExpression, inputtedNumber)
                showCurrentExpression(calculatorDisplay)
            }

            R.id.squareRoot -> {
                currentExpression = Calculate.squareRoot(currentExpression)
                showCurrentExpression(calculatorDisplay)
            }


            R.id.deleteSymbol -> {
                inputtedNumber = if (inputtedNumber.length > 1) {
                    inputtedNumber.substring(0, inputtedNumber.length - 1)
                } else {
                    "0"
                }
                showInputtedNumber(calculatorDisplay)
            }

            else -> {
                inputtedNumber += button.text.toString()
                showInputtedNumber(calculatorDisplay)
            }
        }
    }

    private fun showCurrentExpression(calculatorDisplay: TextView) {
        calculatorDisplay.text = currentExpression
        inputtedNumber = ""
    }

    private fun showInputtedNumber(calculatorDisplay: TextView) {
        calculatorDisplay.text = inputtedNumber
    }
}
