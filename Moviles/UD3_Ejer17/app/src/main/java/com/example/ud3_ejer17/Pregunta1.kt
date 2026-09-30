package com.example.ud3_ejer17

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pregunta1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSiguientePregunta = findViewById<Button>(R.id.btnPregunta2)
        val rbDarthPlagueis = findViewById<RadioButton>(R.id.rbDarthPlagueis)

        btnSiguientePregunta.setOnClickListener {
            if(rbDarthPlagueis.isChecked) {
                val intent = Intent(this, Pregunta2::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}