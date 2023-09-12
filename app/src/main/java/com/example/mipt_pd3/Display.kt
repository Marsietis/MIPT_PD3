package com.example.mipt_pd3

import android.widget.Button
import android.widget.TextView

object Display {

    private var currentExpression = "0"

    fun handleButtonClick(button: Button): String {
        val buttonText = button.text.toString()

        currentExpression = when (buttonText) {
            "C", "CE" -> "0"
            "changeSymbol" -> Calculate.changeSymbol(currentExpression)
            "equal" -> Calculate.calculate(currentExpression)
            else -> currentExpression + buttonText
        }

        return currentExpression
    }
}
