package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //ultimo paso: Recibimos los datos de main activity
        val bundle = intent.extras!!
        val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre"
        val alterEgo = bundle.getString("alterEgo") ?: "No hay alter ego"
        val bio = bundle.getString("superHeroName") ?: "No hay bio"
        val power = bundle.getFloat("power")

        //rellenamos los campos
        /*findViewById<TextView>(R.id.heroeName).text = superHeroName
        findViewById<TextView>(R.id.alter_ego_result).text = alterEgo
        findViewById<TextView>(R.id.bioResult).text = bio
        findViewById<RatingBar>(R.id.power2).rating = power*/

        binding.heroeName.text=superHeroName
        binding.alterEgoResult.text = alterEgo
        binding.bioResult.text = bio
        binding.power2.rating = power
    }
}