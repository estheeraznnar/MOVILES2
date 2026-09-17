package org.iesch.edadcaninca

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Aqui la pantalla esta creada:

        //1- Tomamos el control d etodos los elementos del UI
        val resultText = findViewById<TextView>(R.id.texto_respuesta)
        val calcularBoton = findViewById<Button>(R.id.boton)
        val editText = findViewById<EditText>(R.id.edit)



        //2- Los botones tienen la propiedad setOnClickListener para que sean clicables
        calcularBoton.setOnClickListener {
            //aqui metemos el codigo d elo que queremos hacer cuando pulsemos el boton
            val edadPerro = editText.text.toString()
            if (edadPerro.isEmpty()){
                //3- Mostramos un mensaje de tipo toas
                //resultText.text = "Introduce una edad"
                val mensaje = Toast.makeText(this, "Debes de introducir una edad", Toast.LENGTH_LONG)
                mensaje.show()
            }else{
                //tenemos que pasar el valor a entero
                val edadInt = edadPerro.toInt()
                val dogAge = edadInt * 7

                resultText.text = "Si fueras un perro tu edad seria de ${dogAge} años"
            }

        }

    }
}