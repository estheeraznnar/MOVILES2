package org.iesch.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding


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

        //Apartit fr aqui introduzco el codigo necesario
        val botonguardar = findViewById<Button>(R.id.button)

        botonguardar.setOnClickListener {
            //obtenemos los valores al momento de hacer click
            val superHeroeName=findViewById<EditText>(R.id.hero_name_edit).text.toString()
            val alterEgo = findViewById<EditText>(R.id.alter_ego_edit).text.toString()
            val bio = findViewById<EditText>(R.id.bioEdit).text.toString()
            val power = findViewById<RatingBar>(R.id.power).rating

            //no creo el objeto superheroe
            val superHeroe = superHeroeName, alterEgo, bio, power

            //que quiero hacer cuando pulso el boton guardar
            irADetailActivity(superHeroeName, alterEgo, bio, power)
        }
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
        intent.putExtra("superHeroName", superHeroName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power",power)
        // De esta manera, todos estos datos se enviarán al DetailActivity
        // Iniciamos la nueva actividad
        startActivity(intent)
    }
}