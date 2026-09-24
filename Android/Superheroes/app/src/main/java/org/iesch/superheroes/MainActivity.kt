package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe
import java.io.File

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    //creamos una variable que va a manejar el resultado de haber echo la foto
    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null
    //HAY QUE CAMBIAR EL Takepicturesprevious por take picture
    /*private val getContent = registerForActivityResult( ActivityResultContracts.TakePicturePreview()){
        //Esto nos va a devolver un objeto de tipo bitmap
        bitmap ->
            heroBitmap = bitmap
            heroImage.setImageBitmap(heroBitmap)
    }*/
    private var picturesPath = ""
    private val getContent = registerForActivityResult( ActivityResultContracts.TakePicture()){
        //ahora en lugar de un bitmap nos va a devolver un buleano si la foro es exitosa o no
        success ->
            if (success && picturesPath.isNotEmpty()){
                //cualquier imagen en el direcrtorio la podemos convertir a bitmap
                heroBitmap = BitmapFactory.decodeFile(picturesPath)
                heroImage.setImageBitmap(heroBitmap)
            }
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
        val imagefile = crearImageFile()

        //ya tenemos el archivo tipo file pero necesitamos el uri
        //sera a traves del file provider
        //lo que hace es compartir el file con otras app de forma segura

        val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", imagefile)
        getContent.launch(uri)
    }

    //Esta funcion crea un file y de ese file recuperamos la uri
    fun crearImageFile() : File{
        val fileName = "superhero_image"
        //esto sera el directorio donde vamos a almacenar la imagen. por defecto es DIRECTOREPICTURES
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        //creamos nuestro file aqui nos pide el nombre, el formato y el directorio
        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)
        //ahora ya podemos guardar la ruta de la imagen en la variable global
        picturesPath = imageFile.absolutePath
        return imageFile
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
        intent.putExtra("path_heroe", picturesPath)
        // De esta manera, todos estos datos se enviarán al DetailActivity
        // Iniciamos la nueva actividad
        startActivity(intent)
    }
}