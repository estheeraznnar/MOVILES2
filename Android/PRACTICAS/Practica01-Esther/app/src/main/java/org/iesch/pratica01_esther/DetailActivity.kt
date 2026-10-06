package org.iesch.pratica01_esther

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val imgHero = findViewById<ImageView>(R.id.imgDetailHero)
        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvAlterEgo = findViewById<TextView>(R.id.tvDetailAlterEgo)
        val tvBio = findViewById<TextView>(R.id.tvDetailBio)
        val ratingPower = findViewById<RatingBar>(R.id.ratingDetailPower)

        val name = intent.getStringExtra("HERO_NAME").orEmpty()
        val alterEgo = intent.getStringExtra("ALTER_EGO").orEmpty()
        val bio = intent.getStringExtra("HERO_BIO").orEmpty()
        val power = intent.getFloatExtra("HERO_POWER", 0f)
        val imagePath = intent.getStringExtra("HERO_IMAGE_PATH").orEmpty()

        tvName.text = name

        tvAlterEgo.text = if (alterEgo.isEmpty()) {
            getString(R.string.no_alter_ego)
        } else {
            alterEgo
        }

        tvBio.text = if (bio.isEmpty()) {
            getString(R.string.no_bio)
        } else {
            bio
        }

        ratingPower.rating = power

        if (imagePath.isNotEmpty()) {
            val bitmap = BitmapFactory.decodeFile(imagePath)
            imgHero.setImageBitmap(bitmap)
        }
    }
}