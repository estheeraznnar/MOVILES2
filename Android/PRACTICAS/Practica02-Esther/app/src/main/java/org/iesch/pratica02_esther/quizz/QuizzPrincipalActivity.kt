package org.iesch.pratica02_esther.quizz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.pratica02_esther.R
import org.iesch.pratica02_esther.databinding.ActivityQuizzPrincipalBinding

data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)
class QuizzPrincipalActivity : AppCompatActivity() {

    // View Binding para acceder a los elementos del layout de forma segura
    private lateinit var binding: ActivityQuizzPrincipalBinding

    //Creo una lista de preguntas
    private lateinit var preguntas: List<Pregunta>

    // Índice para seguir la pregunta actual
    private var indice = 0

    // Contador de aciertos del usuario
    private var aciertos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicializo el binding con el layout del Quizz
        binding = ActivityQuizzPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root) // Asigno el layout a la actividad
        supportActionBar?.hide()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Meto las preguntas
        preguntas = listOf(
            Pregunta(getString(R.string.preg1),
                listOf(
                    "Bill Gates",
                    "Steve Jobs",
                    "Elon Musk",
                    "Mark Zuckerberg"
                ),
                1
            ),
            Pregunta(getString(R.string.preg2),
                listOf(
                    getString(R.string.res1),
                    getString(R.string.res2),
                    getString(R.string.res3),
                    getString(R.string.res4),
                ),
                2
            ),
            Pregunta(getString(R.string.preg3),
                listOf("30", "56", "15", "36"),
                1
            ),
            Pregunta(getString(R.string.preg4),
                listOf(
                    getString(R.string.res5),
                    getString(R.string.res6),
                    getString(R.string.res7),
                    getString(R.string.res8),
                ),
                1
            ),
            Pregunta(getString(R.string.preg5),
                listOf(
                    "Windows",
                    "Linux",
                    "MacOS",
                    "Android"
                ),
                1
            )
        )

        // La barra de progreso tiene tantos pasos como preguntas
        binding.progresoQuiz.max = preguntas.size

        mostrarPregunta() // Muestro la primera pregunta

        //Configuro el boton de enviar
        binding.btnenviar.setOnClickListener {
            //Compruebo si se ha seleccionado alguna opcion
            val seleccionada = binding.radioGroup.checkedRadioButtonId
            if (seleccionada == -1){
                //Si no hay ninguna opcion seleccionada, aviso con un Toast
                Toast.makeText(this, R.string.ninguna_respuesta_seleccionada, Toast.LENGTH_SHORT).show()
            }else{
                //Obtengo el indice de la opcion seleccionada segun el id del RadioButton
                val seleccionIndex = when (seleccionada){
                    binding.rbOpcion1.id->0
                    binding.rbOpcion2.id->1
                    binding.rbOpcion3.id->2
                    binding.rbOpcion4.id->3
                    else -> -1
                }

                //Compruebo si la respuesta es correcta
                val esCorrecta = seleccionIndex == preguntas[indice].respuestaCorrecta
                if (esCorrecta) aciertos++ //Incremento los aciertos si es correcta

                //Creo un Intent para cambiar a ResultadoActivity y paso los datos
                val intent = Intent(this, QuizzResultadoActivity::class.java)
                intent.putExtra("acierto", esCorrecta)
                intent.putExtra("indice", indice)
                intent.putExtra("totalPreguntas", preguntas.size)
                intent.putExtra("aciertos", aciertos)
                //Inicio la activity y espero el resultado para continuar
                this.startActivityForResult(intent, 100)
            }
        }
    }

    //Creo un metodo que recibe el resultado al volver de ResultadoActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Solo avanzo si se ha pulsado el botón (no si se ha vuelto con "atrás")
        if (requestCode == 100 && resultCode == RESULT_OK){
            //Avanzo a la siguiente pregunta
            indice ++
            if (indice >= preguntas.size){
                //Si no quedan preguntas (se ha pulsado START AGAIN) empiezo de nuevo
                indice = 0
                aciertos = 0
            }
            mostrarPregunta()
        }
    }

    //Metodo para mostrar la pregunta actual y sus opciones en la UI
    private fun mostrarPregunta() {
        val pregunta = preguntas[indice]
        //Muestro el numero de la pregunta: "1 / 5"
        binding.txNumPreg.text = getString(R.string.numero_preguta, indice + 1, preguntas.size)
        //Actualizo la barra de progreso
        binding.progresoQuiz.progress = indice + 1
        //Texto de la pregunta
        binding.txPregunta.text = pregunta.texto

        //Opciones en cada RadioButton
        binding.rbOpcion1.text = pregunta.opciones[0]
        binding.rbOpcion2.text = pregunta.opciones[1]
        binding.rbOpcion3.text = pregunta.opciones[2]
        binding.rbOpcion4.text = pregunta.opciones[3]

        //Limpio la seleccion previa para empezar sin nada
        binding.radioGroup.clearCheck()
    }
}