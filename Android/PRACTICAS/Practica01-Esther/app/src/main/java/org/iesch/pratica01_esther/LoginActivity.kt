package org.iesch.pratica01_esther

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val etName = findViewById<EditText>(R.id.etName)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = getString(R.string.name_required)
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }
    }
}