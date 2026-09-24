package org.iesch.superheroes

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding
import org.iesch.superheroes.model.SuperHeroe

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

        //recibimos el objeto superheroe del intent
        val superHeroe = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU){
            //Para versiones SDK 33 o superiores
            intent.getParcelableExtra("superHero", SuperHeroe::class.java)
        }else{
            intent.getParcelableExtra<SuperHeroe>("superHero")
        }

        val bitmap = bundle.getParcelable<Bitmap>("foto_heroe")

        //rellenamos los campos
        /*findViewById<TextView>(R.id.heroeName).text = superHeroName
        findViewById<TextView>(R.id.alter_ego_result).text = alterEgo
        findViewById<TextView>(R.id.bioResult).text = bio
        findViewById<RatingBar>(R.id.power2).rating = power*/

        binding.heroeName.text= superHeroe?.nombre ?:"No hay nombre"
        binding.alterEgoResult.text = superHeroe?.alterEgo ?:"No hay alter ego"
        binding.bioResult.text = superHeroe?.bio ?:"No hay bio"
        binding.power2.rating = superHeroe?.power ?: 0f

        binding.imageheroedetaill.setImageBitmap(bitmap)
    }
}