package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

object Display {

    private var currentExpression = ""
    fun handleButtonClick(button: Button, calculatorDisplay: TextView) {
        val buttonText = button.text.toString()

        if (buttonText.isDigitsOnly()) {
            currentExpression += buttonText
        } else if (buttonText == "+" || buttonText == "-" || buttonText == "*" || buttonText == "/") {
            currentExpression += " $buttonText "
        }
        calculatorDisplay.text = currentExpression
    }
}