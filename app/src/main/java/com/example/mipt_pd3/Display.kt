package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView

object Display {

    private var currentExpression = ""
    fun handleButtonClick(button: Button, calculatorDisplay: TextView): String {
        val buttonText = button.text.toString()

        if (buttonText == "C" || buttonText == "CE") {
            currentExpression = "0"
        } else if (button.id.toString() == "changeSymbol") {
            currentExpression = Calculate.changeSymbol(currentExpression)
        } else if (button.id.toString() == "equal") {
            currentExpression = Calculate.calculate(currentExpression)
        } else {
            currentExpression += buttonText
        }

        return currentExpression
    }
}