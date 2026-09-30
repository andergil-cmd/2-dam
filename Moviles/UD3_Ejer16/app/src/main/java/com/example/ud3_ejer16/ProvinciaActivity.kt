package com.example.ud3_ejer16

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProvinciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_provincia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonProvincia = findViewById<Button>(R.id.button2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        buttonProvincia.setOnClickListener {

            val seleccion = radioGroup.checkedRadioButtonId
            if (seleccion != -1) {
                val radioButtonId = findViewById<RadioButton>(seleccion)
                val textoSeleccionado = radioButtonId.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("PROVINCIA", textoSeleccionado)

                setResult(RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "Selecciona una provincia", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
