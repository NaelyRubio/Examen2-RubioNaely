package rubio.naely.examen2_rubionaely

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LlamadaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamada)

        // Recibe el nombre del intent
        val nombre = intent.getStringExtra("nombre") ?: ""

        // Referencias a los elementos
        val txtLlamando = findViewById<TextView>(R.id.txtLlamando)
        val btnColgar = findViewById<Button>(R.id.btnColgar)

        // Mostrar mensaje
        txtLlamando.text = "Llamando a $nombre..."

        // Terminar la actividad al colgar
        btnColgar.setOnClickListener {
            finish()
        }
    }
}
