package rubio.naely.examen2_rubionaely

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var botonAgregar: Button
    private lateinit var adapter: ContactoAdapter

    private val contactos = mutableListOf(
        Contacto("Lucía", "Peña", "Secretaría de Salud Pública", "lucia@correo.com", "6441234567", colorParaNombre("Lucía")),
        Contacto("Gilberto", "Borrego", "Gamesa", "gilberto@correo.com", "6442223333", colorParaNombre("Gilberto")),
        Contacto("Beatriz", "Vizcarra", "Gelattina", "beatriz@correo.com", "6449876543", colorParaNombre("Beatriz"))
    )

    // Registro para manejar el resultado de la actividad AgregarContactoActivity
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val nuevoContacto = result.data?.getParcelableExtra<Contacto>("nuevoContacto")
            nuevoContacto?.let {
                // Agregar el nuevo contacto a la lista y actualizar el RecyclerView
                contactos.add(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas
        recycler = findViewById(R.id.recyclerContactos)
        botonAgregar = findViewById(R.id.botonAgregar)

        adapter = ContactoAdapter(contactos,
            onEliminar = { contacto ->
                contactos.remove(contacto)
                adapter.notifyDataSetChanged()
            },
            onClickContacto = { contacto ->
                val intent = Intent(this, DetalleActivity::class.java)
                intent.putExtra("contacto", contacto)  // Pasa el contacto completo
                startActivity(intent)
            }
        )


        // Establecer el LayoutManager y el adaptador
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // Manejar el evento de clic del botón "Agregar contacto"
        botonAgregar.setOnClickListener {
            val intent = Intent(this, AgregarContactoActivity::class.java)
            startForResult.launch(intent)  // Usamos startForResult para recibir el contacto agregado
        }
    }

    // Función para generar un color basado en el nombre del contacto
    private fun colorParaNombre(nombre: String): Int {
        val colores = listOf(
            Color.parseColor("#4DD0E1"),
            Color.parseColor("#0097A7"),
            Color.parseColor("#80DEEA"),
            Color.parseColor("#26C6DA"),
            Color.parseColor("#00BCD4")
        )
        return colores[nombre.hashCode().absoluteValue % colores.size]
    }
}
