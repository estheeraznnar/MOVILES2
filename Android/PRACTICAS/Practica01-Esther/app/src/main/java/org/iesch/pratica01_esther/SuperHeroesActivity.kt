package org.iesch.pratica01_esther

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import org.iesch.pratica01_esther.model.SuperHeroe
import java.io.File

class SuperHeroesActivity : AppCompatActivity() {

    private lateinit var imgHero: ImageView
    private var imagePath = ""

    private val takePicture = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && imagePath.isNotEmpty()) {
            val bitmap = BitmapFactory.decodeFile(imagePath)
            imgHero.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_superheroes)

        imgHero = findViewById(R.id.imgHero)

        val etName = findViewById<EditText>(R.id.etHeroName)
        val etAlterEgo = findViewById<EditText>(R.id.etAlterEgo)
        val etBio = findViewById<EditText>(R.id.etBio)
        val ratingPower = findViewById<RatingBar>(R.id.ratingPower)
        val btnSave = findViewById<Button>(R.id.btnSaveHero)

        imgHero.setOnClickListener {
            openCamera()
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val alterEgo = etAlterEgo.text.toString().trim()
            val bio = etBio.text.toString().trim()
            val power = ratingPower.rating

            if (name.isEmpty()) {
                etName.error = getString(R.string.hero_name_required)
                return@setOnClickListener
            }

            if (imagePath.isEmpty()) {
                imgHero.contentDescription = getString(R.string.hero_image_required)
                return@setOnClickListener
            }

            val superHeroe = SuperHeroe(
                nombre = name,
                alterEgo = alterEgo,
                bio = bio,
                power = power,
                imagePath = imagePath
            )

            openDetail(superHeroe)
        }
    }

    private fun openCamera() {
        val imageFile = createImageFile()

        val imageUri: Uri = FileProvider.getUriForFile(
            this,
            "${applicationContext.packageName}.provider",
            imageFile
        )

        takePicture.launch(imageUri)
    }

    private fun createImageFile(): File {
        val picturesDirectory = getExternalFilesDir(
            Environment.DIRECTORY_PICTURES
        )

        val imageFile = File.createTempFile(
            "superhero_",
            ".jpg",
            picturesDirectory
        )

        imagePath = imageFile.absolutePath

        return imageFile
    }

    private fun openDetail(superHeroe: SuperHeroe) {
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra("HERO_NAME", superHeroe.nombre)
        intent.putExtra("ALTER_EGO", superHeroe.alterEgo)
        intent.putExtra("HERO_BIO", superHeroe.bio)
        intent.putExtra("HERO_POWER", superHeroe.power)
        intent.putExtra("HERO_IMAGE_PATH", superHeroe.imagePath)

        startActivity(intent)
    }
}