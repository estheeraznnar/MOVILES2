package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    //creamos una variable que va a manejar el resultado de haber echo la foto
    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null
    private val getContent = registerForActivityResult( ActivityResultContracts.TakePicturePreview()){
        //Esto nos va a devolver un objeto de tipo bitmap
        bitmap ->
            heroBitmap = bitmap
            heroImage.setImageBitmap(heroBitmap)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 2 - Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 3 - Usamos el binding para inflar la vista
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        heroImage = binding.imageView
        binding.imageView.setOnClickListener {
            abrirCamara()
        }

        //Apartit fr aqui introduzco el codigo necesario
        val botonguardar = findViewById<Button>(R.id.button)

        botonguardar.setOnClickListener {
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.alterEgoEdit.text.toString()
            val power = binding.power.rating
            // 2 - Me creo el objeto SuperHeroe
            val superHeroe = SuperHeroe(superHeroName,alterEgo,bio,power)
            // Qué quiero hacer cuando pulso el Boton Guardar
            irADetailActivity(superHeroe)
        }
    }

    fun abrirCamara() {
        //abrimaos la camara llamando al getcontent launch
        getContent.launch(null)
    }

    /*fun irADetailActivity(superHeroeName: String, alterEgo: String, bio: String, power: Float) {
        //creamis el objeto intent
        val intent = Intent(this, DetailActivity::class.java)
        //Añadimos todos los campos con el metodo putExtra
        intent.putExtra("superHeroName", superHeroeName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        //de esta manera todos estos datos se mandaran a detailactivity
        //iniciamos la nueva actividad
        startActivity(intent)
    }*/
    fun irADetailActivity(superHeroe: SuperHeroe) {
        // Creamos el objeto Intent
        val intent = Intent(this, DetailActivity::class.java)
        // Añadimos todos los campos con el metodo putExtra
        //intent.putExtra("superHeroName", superHeroName)
        //intent.putExtra("alterEgo", alterEgo)
        //intent.putExtra("bio", bio)
        //intent.putExtra("power",power)
        intent.putExtra( "superHero", superHeroe )
        // añadp el objeto bitmap el intent
        intent.putExtra("foto_heroe", heroImage.drawable.toBitmap() )
        // De esta manera, todos estos datos se enviarán al DetailActivity
        // Iniciamos la nueva actividad
        startActivity(intent)
    }
}