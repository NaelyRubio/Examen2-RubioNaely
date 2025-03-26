package rubio.naely.examen2_rubionaely

import rubio.naely.examen2_rubionaely.Contacto
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.drawable.GradientDrawable
import android.widget.Toast

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        // Obtener el contacto del intent
        val contacto = intent.getParcelableExtra<Contacto>("contacto")

        // Verifica si el contacto no es nulo
        if (contacto != null) {
            val txtCirculo = findViewById<TextView>(R.id.txtCirculo)
            val txtNombreCompleto = findViewById<TextView>(R.id.txtNombreCompleto)
            val txtCompania = findViewById<TextView>(R.id.txtCompaniaContacto)
            val txtCorreo = findViewById<TextView>(R.id.txtCorreoContacto)
            val txtTelefono = findViewById<TextView>(R.id.txtTelefonoContacto)
            val btnLlamar = findViewById<Button>(R.id.btnLlamar)

            // Mostrar datos del contacto
            txtCirculo.text = contacto.nombre.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
            txtNombreCompleto.text = "${contacto.nombre} ${contacto.apellido}"
            txtCompania.text = contacto.compania
            txtCorreo.text = contacto.correo
            txtTelefono.text = contacto.telefono
            btnLlamar.text = "Llamar a ${contacto.nombre}"

            // Pintar el círculo con el color del contacto
            val fondo = txtCirculo.background as GradientDrawable
            fondo.setColor(contacto.color)

            // Ir a la pantalla de llamada (si la tienes)
            btnLlamar.setOnClickListener {
                val intent = Intent(this, LlamadaActivity::class.java)
                intent.putExtra("nombre", contacto.nombre)
                startActivity(intent)
            }
        }
    }

}