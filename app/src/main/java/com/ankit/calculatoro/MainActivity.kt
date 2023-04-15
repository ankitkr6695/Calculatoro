package com.ankit.calculatoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ankit.calculatoro.R

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)

        val button0: Button = findViewById(R.id.button_0)
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val buttonDecimal: Button = findViewById(R.id.button_decimal)

        val buttonAdd: Button = findViewById(R.id.button_add)
        val buttonSubtract: Button = findViewById(R.id.button_subtract)
        val buttonMultiply: Button = findViewById(R.id.button_multiply)
        val buttonDivide: Button = findViewById(R.id.button_divide)

        val buttonEqual: Button = findViewById(R.id.button_equal)
        val buttonClear: Button = findViewById(R.id.button_clear)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            resultText.append(b.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDecimal.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            if (resultText.text.isNotEmpty()) {
                operand1 = resultText.text.toString().toDouble()
            }
            operation = op
            resultText.text = ""
        }

        buttonAdd.setOnClickListener(opListener)
        buttonSubtract.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)

        buttonEqual.setOnClickListener {
            val result: Double
            operand2 = resultText.text.toString().toDouble()

            when (operation) {
                "+" -> {
                    result = operand1 + operand2
                    resultText.text = result.toString()
                }
                "-" -> {
                    result = operand1 - operand2
                    resultText.text = result.toString()
                }
                "*" -> {
                    result = operand1 * operand2
                    resultText.text = result.toString()
                }
                "/" -> {
                    result = operand1 / operand2
                    resultText.text = result.toString()
                }
            }
        }

        buttonClear.setOnClickListener {
            resultText.text = ""
            operand1 = 0.0
            operand2 = 0.0
            operation = ""
        }
    }
}

