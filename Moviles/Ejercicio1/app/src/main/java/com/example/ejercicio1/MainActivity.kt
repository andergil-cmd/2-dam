package com.example.ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        val textView: TextView = findViewById(R.id.textView)

        val editText: EditText = findViewById(R.id.editText)

        button.setOnClickListener {
           val textoIngresado = editText.text.toString()
            if (button.text.toString() == "Comprobar") {
                if (textoIngresado.isNotEmpty()) {
                    val numero = textoIngresado.toInt()
                    if (esPrimo(numero)) {
                        textView.text = getString(R.string.esPrimo, numero)
                    } else {
                        textView.text = getString(R.string.noEsPrimo, numero)
                        button.text = getString(R.string.button2)
                    }
                }
            }else if (button.text.toString() == "Reiniciar") {
                textView.text = getString(R.string.textView)
                editText.text.clear()
                button.text = getString(R.string.button)

            }




        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun esPrimo(numero: Int): Boolean {
        if (numero <= 1) {
            return false
        }
        for (i in 2 until numero) {
            if (numero % i == 0) {
                return false
            }
        }
        return true
    }
}