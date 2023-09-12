package com.example.mipt_pd3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculatorDisplay = findViewById<TextView>(R.id.display)

        val buttonIds = listOf(
            R.id._0,
            R.id._1,
            R.id._2,
            R.id._3,
            R.id._4,
            R.id._5,
            R.id._6,
            R.id._7,
            R.id._8,
            R.id._9,
            R.id.plus,
            R.id.minus,
            R.id.multiply,
            R.id.divide,
            R.id.squareRoot,
            R.id.deleteSymbol,
            R.id.clear,
            R.id.clearEntry,
            R.id.changeSymbol
        )

        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                Display.handleButtonClick(button, calculatorDisplay)
            }
        }
    }


}