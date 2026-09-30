package com.example.ud3_ejer16

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonProvincia = findViewById<Button>(R.id.button)
        val texto = findViewById<TextView>(R.id.tvTexto)

        val launcherProvincia = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val provinciaSeleccionada = data?.getStringExtra("PROVINCIA")
                texto.text = "Provincia Seleccionada: \n$provinciaSeleccionada"
            }
        }


        buttonProvincia.setOnClickListener {
            val intent = Intent(this, ProvinciaActivity::class.java)
            launcherProvincia.launch(intent)
        }

    }
}