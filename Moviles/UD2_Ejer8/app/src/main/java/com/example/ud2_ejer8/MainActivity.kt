package com.example.ud2_ejer8

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etDNI = findViewById<EditText>(R.id.etDNI)
        val cbHombre = findViewById<CheckBox>(R.id.cbHombre)
        val cbMujer = findViewById<CheckBox>(R.id.cbMujer)
        val fecha = findViewById<EditText>(R.id.etFecha)
        val button = findViewById<Button>(R.id.button)

        val imagen = findViewById<ImageView>(R.id.ivImagen)


        button.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val regex = Regex("^[a-zA-Z]+$")
            val dni = etDNI.text.toString().trim().uppercase()

            if (nombre.length !in 2..15 || !nombre.matches(regex)) {
                Toast.makeText(this, "El nombre debe tener entre 2 y 15 caracteres y solo letras", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (apellido.length !in 2..15 || !apellido.matches(regex)) {
                Toast.makeText(this, "El apellido debe tener entre 2 y 15 caracteres y solo letras", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!validarDNI(dni)) {
                Toast.makeText(this, "El DNI debe tener 8 números y una letra", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!validarLetraDNI(dni)){
                Toast.makeText(this, "La letra del DNI no es correcta", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(cbHombre.isChecked && cbMujer.isChecked){
                Toast.makeText(this, "Por favor, selecciona solo un sexo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(cbHombre.isChecked){
                imagen.setImageResource(R.drawable.hombre)
            }else if(cbMujer.isChecked){
                imagen.setImageResource(R.drawable.mujer)
            } else {
                Toast.makeText(this, "Por favor, selecciona un sexo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fechaStr = fecha.text.toString()
            if(fechaStr.isEmpty()){
                Toast.makeText(this, "La fecha no puede estar vacía", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edad = calcularEdad(fechaStr)
            if (edad == -1){
                Toast.makeText(this, "Formato de fecha no válido (dd/mm/aaaa)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (edad < 20){
                Toast.makeText(this, "Debes ser mayor de 20 años para registrarte", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Formulario enviado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calcularEdad(fechaNacimiento: String): Int {
        // Soporta formatos comunes según cómo escriba el usuario (con guiones o barras)
        val formato = if (fechaNacimiento.contains("-")) {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        } else {
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        }
        return try {
            val fechaNac = formato.parse(fechaNacimiento) ?: return -1

            val hoy = Calendar.getInstance()
            val nacimiento = Calendar.getInstance()
            nacimiento.time = fechaNac

            var edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR)

            // Ajuste por si aún no ha cumplido años en el año en curso
            if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
                edad--
            }
            edad
        } catch (_: Exception) {
            -1 // Devuelve -1 si el formato introducido es incorrecto
        }
    }

    fun validarLetraDNI(dni: String): Boolean {
        val letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE"
        val numeros = dni.substring(0, 8).toInt()
        val letraIntroducida = dni.last()

        val resto = numeros % 23
        val letraCalculada = letrasDni[resto]

        return letraCalculada == letraIntroducida
    }

    fun validarDNI(dni: String): Boolean {
        val regex = Regex("^[0-9]{8}[A-Z]$")
        if (!regex.matches(dni)) {
            return false
        }
        return validarLetraDNI(dni)
    }
}






