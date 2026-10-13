package org.iesch.pratica02_esther

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.pratica02_esther.quizz.QuizzPrincipalActivity

class HomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USUARIO = "usuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usuario = intent.getStringExtra(EXTRA_USUARIO) ?: ""
        findViewById<TextView>(R.id.tvSaludo).text = getString(R.string.saludo_usuario, usuario)

        findViewById<View>(R.id.cardEdadCanina).setOnClickListener {
            startActivity(Intent(this, EdadCaninaActivity::class.java))
        }
        findViewById<View>(R.id.cardSuperHeroes).setOnClickListener {
            startActivity(Intent(this, SuperHeroesActivity::class.java))
        }
        // Salir: cerramos el menú y volvemos a la pantalla de login
        findViewById<View>(R.id.cardSalir).setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.cardQuizzes).setOnClickListener {
            startActivity(Intent(this, QuizzPrincipalActivity::class.java))
        }
    }
}
