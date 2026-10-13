package org.iesch.pratica02_esther

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val btnEntrar = findViewById<View>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()

            if (usuario.isEmpty()) {
                etUsuario.error = getString(R.string.error_usuario_vacio)
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(HomeActivity.EXTRA_USUARIO, usuario)
                startActivity(intent)
            }
        }
    }
}
