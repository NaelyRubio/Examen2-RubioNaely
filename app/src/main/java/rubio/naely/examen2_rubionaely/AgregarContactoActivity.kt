package rubio.naely.examen2_rubionaely

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AgregarContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val apellido = findViewById<EditText>(R.id.etApellido).text.toString()
            val compania = findViewById<EditText>(R.id.etCompania).text.toString()
            val correo = findViewById<EditText>(R.id.etCorreo).text.toString()
            val telefono = findViewById<EditText>(R.id.etTelefono).text.toString()

            // Aquí seleccionas un color aleatorio o prefijado
            val color = Color.parseColor("#FF6347")  // Usando el color tomate de ejemplo

            val nuevoContacto = Contacto(nombre, apellido, compania, correo, telefono, color)

            val intent = Intent()
            intent.putExtra("nuevoContacto", nuevoContacto)
            setResult(RESULT_OK, intent)
            finish()  // Cerrar la actividad
        }
    }
}
