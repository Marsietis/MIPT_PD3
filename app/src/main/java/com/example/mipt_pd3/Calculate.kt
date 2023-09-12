package com.example.mipt_pd3

object Calculate {
    fun changeSymbol(expression: String): String {
        return if (expression.startsWith("-")) {
            expression.substring(1)
        } else {
            "-$expression"
        }
    }

    fun calculate(){

    }
}