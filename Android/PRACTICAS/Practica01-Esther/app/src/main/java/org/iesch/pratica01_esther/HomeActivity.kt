package org.iesch.pratica01_esther

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val tvUserName = findViewById<TextView>(R.id.tvUserName)

        val cardDogAge = findViewById<View>(R.id.cardDogAge)
        val cardSuperheroes = findViewById<View>(R.id.cardSuperheroes)
        val cardQuestion = findViewById<View>(R.id.cardQuestion)
        val cardSettings = findViewById<View>(R.id.cardSettings)
        val cardFavorite = findViewById<View>(R.id.cardFavorite)
        val cardLogout = findViewById<View>(R.id.cardLogout)

        val userName = intent.getStringExtra("USER_NAME") ?: ""
        tvUserName.text = getString(R.string.user_greeting, userName)

        cardDogAge.setOnClickListener {
            startActivity(Intent(this, EdadCaninaActivity::class.java))
        }

        cardSuperheroes.setOnClickListener {
            startActivity(Intent(this, SuperHeroesActivity::class.java))
        }

        cardQuestion.setOnClickListener {
            Toast.makeText(this, R.string.question_button, Toast.LENGTH_SHORT).show()
        }

        cardSettings.setOnClickListener {
            Toast.makeText(this, R.string.settings_button, Toast.LENGTH_SHORT).show()
        }

        cardFavorite.setOnClickListener {
            Toast.makeText(this, R.string.favorite_button, Toast.LENGTH_SHORT).show()
        }

        cardLogout.setOnClickListener {
            finish()
        }
    }
}