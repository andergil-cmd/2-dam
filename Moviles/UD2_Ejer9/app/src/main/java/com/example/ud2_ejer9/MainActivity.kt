package com.example.ud2_ejer9

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    private var estadoLlamada = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvEstado = findViewById<TextView>(R.id.tvEstado)
        val btnLlamar = findViewById<ImageButton>(R.id.btnLlamar)
        val ivWalter = findViewById<ImageView>(R.id.ivWalter)

        btnLlamar.setOnClickListener {
            when (estadoLlamada) {
                1 -> {
                    tvEstado.text = "Llamando a Walter White..."
                    ivWalter.setImageResource(R.drawable.heisenberg)
                    btnLlamar.setImageResource(R.drawable.telefono_rojo)
                    btnLlamar.backgroundTintList = android.content.res.ColorStateList.valueOf("#FF0000".toColorInt())
                    estadoLlamada = 2
                }
                2 -> {
                    tvEstado.text = "Pulsa para llamar a Walter White"
                    ivWalter.setImageResource(R.drawable.walter_white)
                    btnLlamar.setImageResource(R.drawable.telefono_verde)
                    btnLlamar.backgroundTintList = android.content.res.ColorStateList.valueOf("#64F04A".toColorInt())
                    estadoLlamada = 1
                }
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}