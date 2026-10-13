package org.iesch.pratica02_esther.quizz

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.pratica02_esther.R
import org.iesch.pratica02_esther.databinding.ActivityQuizzResultadoBinding

class QuizzResultadoActivity : AppCompatActivity() {
    // View Binding para acceder a los elementos del layout de forma segura
    private lateinit var binding: ActivityQuizzResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicializo el binding con el layout del resultado
        binding = ActivityQuizzResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root) // Asigno el layout a la actividad
        supportActionBar?.hide()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recupero datos del intent
        val acierto = intent.getBooleanExtra("acierto", false)
        val indice = intent.getIntExtra("indice", 0)
        val total = intent.getIntExtra("totalPreguntas", 0)
        val aciertos = intent.getIntExtra("aciertos", 0)

        // Muestro si la respuesta fue correcta o incorrecta
        if (acierto) {
            binding.tvIcono.text = "✓"
            binding.tvIcono.setTextColor(ContextCompat.getColor(this, R.color.quiz_acierto))
            binding.tvIcono.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.quiz_acierto_claro))
            binding.txResultado.text = getString(R.string.respuesta_correcta)
            binding.txMensaje.text = getString(R.string.respuesta_correcta_mensaje)
        } else {
            binding.tvIcono.text = "✗"
            binding.tvIcono.setTextColor(ContextCompat.getColor(this, R.color.quiz_fallo))
            binding.tvIcono.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.quiz_fallo_claro))
            binding.txResultado.text = getString(R.string.respuesta_incorrecta)
            binding.txMensaje.text = getString(R.string.respuesta_incorrecta_mensaje)
        }

        // Si es la última pregunta muestro el resumen final y el botón "Start again"
        if (indice == total - 1) {
            binding.txFinal.visibility = View.VISIBLE
            binding.txFinal.text = getString(R.string.final_quizz, aciertos, total)
            binding.btnSiguiente.text = getString(R.string.empezar_de_nuevo)
        } else {
            binding.txFinal.visibility = View.GONE
            binding.btnSiguiente.text = getString(R.string.boton_siguiente)
        }

        // Al pulsar "Next" o "Start again" cerramos esta activity y volvemos a PrincipalActivity
        binding.btnSiguiente.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}