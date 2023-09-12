package com.example.mipt_pd3

import android.widget.Button

object Display {

    private var currentExpression = "0"

    fun handleButtonClick(button: Button): String {

        when (button.id) {
            R.id.clear, R.id.clearEntry -> currentExpression = ""
            R.id.changeSymbol -> currentExpression = Calculate.changeSymbol(currentExpression)
            //R.id.equal -> currentExpression = Calculate.calculate(currentExpression)
            R.id.deleteSymbol -> {
                currentExpression = if (currentExpression.length > 1) {
                    currentExpression.substring(0, currentExpression.length - 1)
                } else {
                    "0"
                }
            }

            else -> {
                if (currentExpression == "0") {
                    currentExpression = button.text.toString()
                } else {
                    currentExpression += button.text.toString()
                }
            }

        }


        return currentExpression
    }
}
