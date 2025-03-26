package rubio.naely.examen2_rubionaely

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter(

    private val contactos: MutableList<Contacto>,
    private val onEliminar: (Contacto) -> Unit,
    private val onClickContacto: (Contacto) -> Unit
) : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val inicial: TextView = itemView.findViewById(R.id.inicial)
        val nombre: TextView = itemView.findViewById(R.id.txtNombre)
        val compania: TextView = itemView.findViewById(R.id.txtCompania)
        val btnEliminar: ImageView = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto = contactos[position]
        val nombreCompleto = "${contacto.nombre} ${contacto.apellido}"

        holder.nombre.text = nombreCompleto
        holder.compania.text = contacto.compania
        holder.inicial.text = contacto.nombre.first().uppercaseChar().toString()

        // rellenar el circulo con el color del contacto
        val fondo = holder.inicial.background as GradientDrawable
        fondo.setColor(contacto.color)

        holder.btnEliminar.setOnClickListener {
            onEliminar(contacto)
        }

        holder.itemView.setOnClickListener {
            onClickContacto(contacto)
        }
    }

    override fun getItemCount(): Int = contactos.size
}
