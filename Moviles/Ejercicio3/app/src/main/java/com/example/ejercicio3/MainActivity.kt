package com.example.ejercicio3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var tvResultado: TextView
    lateinit var tvError: TextView

    var operacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvResultado = findViewById(R.id.textResultado)
        tvError = findViewById(R.id.textError)

        findViewById<Button>(R.id.btn0).setOnClickListener {
            ocultarError()
            operacion += "0"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            ocultarError()
            operacion += "1"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            ocultarError()
            operacion += "2"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            ocultarError()
            operacion += "3"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn4).setOnClickListener {
            ocultarError()
            operacion += "4"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn5).setOnClickListener {
            ocultarError()
            operacion += "5"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn6).setOnClickListener {
            ocultarError()
            operacion += "6"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn7).setOnClickListener {
            ocultarError()
            operacion += "7"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn8).setOnClickListener {
            ocultarError()
            operacion += "8"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btn9).setOnClickListener {
            ocultarError()
            operacion += "9"
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btnSuma).setOnClickListener {
            ocultarError()
            operacion += " + "
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btnResta).setOnClickListener {
            ocultarError()
            operacion += " - "
            tvResultado.text = operacion
        }

        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            ocultarError()

            try {
                val resultado = Operations().doOperation(operacion)
                tvResultado.text = resultado
                operacion = resultado
            }catch (error: Exception){
                tvError.visibility = View.VISIBLE
                tvResultado.text = ""
                operacion = ""
            }
        }

    }

    private fun ocultarError() {
        tvError.visibility = View.INVISIBLE
    }
}