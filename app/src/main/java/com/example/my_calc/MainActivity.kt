package com.example.my_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var expression = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var expression = findViewById<TextView>(R.id.expression)
        var result = findViewById<TextView>(R.id.result)
        val bu1 = findViewById<Button>(R.id.bu1)
        val bu2 = findViewById<Button>(R.id.bu2)
        val bu3 = findViewById<Button>(R.id.bu3)
        val bu4 = findViewById<Button>(R.id.bu4)
        val bu5 = findViewById<Button>(R.id.bu5)
        val bu6 = findViewById<Button>(R.id.bu6)
        val bu7 = findViewById<Button>(R.id.bu7)
        val bu8 = findViewById<Button>(R.id.bu8)
        val bu9 = findViewById<Button>(R.id.bu9)
        val bu0 = findViewById<Button>(R.id.bu0)
        val buDot = findViewById<Button>(R.id.buDot)
        val buPer = findViewById<Button>(R.id.buPer)
        val buAc = findViewById<Button>(R.id.buAC)
        val buDiv = findViewById<Button>(R.id.buDiv)
        val buSum = findViewById<Button>(R.id.buSum)
        val buSub = findViewById<Button>(R.id.buSub)
        val buMul = findViewById<Button>(R.id.buMul)
        val buEq = findViewById<Button>(R.id.buEq)
        val buBack = findViewById<Button>(R.id.buBack)


        fun addToExpression(str : String) {
            expression.append(str)
        }

        bu0.setOnClickListener { addToExpression("0") }
        bu1.setOnClickListener { addToExpression("1") }
        bu2.setOnClickListener { addToExpression("2") }
        bu3.setOnClickListener { addToExpression("3") }
        bu4.setOnClickListener { addToExpression("4") }
        bu5.setOnClickListener { addToExpression("5") }
        bu6.setOnClickListener { addToExpression("6") }
        bu7.setOnClickListener { addToExpression("7") }
        bu8.setOnClickListener { addToExpression("8") }
        bu9.setOnClickListener { addToExpression("9") }
        buDot.setOnClickListener { addToExpression(".") }
        buSum.setOnClickListener { addToExpression("+") }
        buSub.setOnClickListener { addToExpression("-") }
        buMul.setOnClickListener { addToExpression("*") }
        buDiv.setOnClickListener { addToExpression("/") }
        buDot.setOnClickListener { addToExpression(".") }

        buBack.setOnClickListener {
            val str = expression.text.toString()
            if (str.isNotEmpty()) {
                expression.text = str.substring(0 , str.length-1)
            }
        }
        buAc.setOnClickListener {
            expression.text = " "
            result.text = " "
        }

        buEq.setOnClickListener {
            val exp = ExpressionBuilder(expression.text.toString()).build()
            val res = exp.evaluate()
            result.text = res.toString()
        }

    }
}