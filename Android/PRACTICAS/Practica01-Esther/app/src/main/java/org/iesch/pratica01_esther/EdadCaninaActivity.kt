package org.iesch.pratica01_esther

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EdadCaninaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edad_canina)

        val resultText = findViewById<TextView>(R.id.texto_respuesta)
        val calcularBoton = findViewById<Button>(R.id.boton)
        val editText = findViewById<EditText>(R.id.edit)

        calcularBoton.setOnClickListener {
            val edad = editText.text.toString().trim().toIntOrNull()

            if (edad == null || edad < 0) {
                editText.error = getString(R.string.canina_invalid_age)
                resultText.text = ""
            } else {
                val edadCanina = edad * 7

                resultText.text = getString(
                    R.string.canina_result,
                    edadCanina
                )
            }
        }
    }
}