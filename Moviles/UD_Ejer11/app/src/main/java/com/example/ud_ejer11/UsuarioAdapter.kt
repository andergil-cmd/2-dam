package com.example.ud_ejer11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(
    private val usuarios: List<Usuario>,
    private val onAddClick: () -> Unit,
    private val onDeleteClick: (Int) -> Unit,
    private val onUpdateClick: (Int) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombreCompleto: TextView = view.findViewById(R.id.tvNombreCompleto)
        val tvEdad: TextView = view.findViewById(R.id.tvEdad)
        val btnAgregar: Button = view.findViewById(R.id.btnAgregar)
        val buttonBorrar: Button = view.findViewById(R.id.buttonBorrar)
        val buyttonModificar: Button = view.findViewById(R.id.buyttonModificar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        val context = holder.itemView.context
        
        holder.tvNombreCompleto.text = context.getString(R.string.nombre_apellidos, usuario.nombre, usuario.apellidos)
        holder.tvEdad.text = context.getString(R.string.edad_formato, usuario.edad)

        holder.btnAgregar.setOnClickListener {
            onAddClick()
        }

        holder.buttonBorrar.setOnClickListener {
            val adapterPos = holder.bindingAdapterPosition
            if (adapterPos != RecyclerView.NO_POSITION) {
                onDeleteClick(adapterPos)
            }
        }

        holder.buyttonModificar.setOnClickListener {
            val adapterPos = holder.bindingAdapterPosition
            if (adapterPos != RecyclerView.NO_POSITION) {
                onUpdateClick(adapterPos)
            }
        }
    }

    override fun getItemCount(): Int = usuarios.size
}
