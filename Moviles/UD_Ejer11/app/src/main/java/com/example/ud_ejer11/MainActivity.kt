package com.example.ud_ejer11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ud_ejer11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: UsuarioAdapter
    private val listaUsuarios = mutableListOf(
        Usuario("Juan", "Pérez Gómez", 28),
        Usuario("María", "López Martínez", 34),
        Usuario("Carlos", "Sánchez Ruiz", 42),
        Usuario("Ana", "Fernández Torres", 22)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Inicializar View Binding PRIMERO
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Aplicar insets en la raíz ya inicializada
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Configurar RecyclerView y Adaptador con callbacks
        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)
        
        adaptador = UsuarioAdapter(
            usuarios = listaUsuarios,
            onAddClick = {
                // Ejemplo: Añadir un nuevo usuario por defecto
                listaUsuarios.add(Usuario("Nuevo", "Usuario", 20))
                adaptador.notifyItemInserted(listaUsuarios.size - 1)
            },
            onDeleteClick = { position ->
                // Borrar usuario en esa posición (o por nombre)
                if (position in listaUsuarios.indices) {
                    listaUsuarios.removeAt(position)
                    adaptador.notifyItemRemoved(position)
                    adaptador.notifyItemRangeChanged(position, listaUsuarios.size)
                }
            },
            onUpdateClick = { position ->
                // Modificar edad del usuario en esa posición
                if (position in listaUsuarios.indices) {
                    val usuario = listaUsuarios[position]
                    // Ejemplo: incrementar edad en 1
                    listaUsuarios[position] = usuario.copy(edad = usuario.edad + 1)
                    adaptador.notifyItemChanged(position)
                }
            }
        )
        
        binding.rvUsuarios.adapter = adaptador
    }
}
