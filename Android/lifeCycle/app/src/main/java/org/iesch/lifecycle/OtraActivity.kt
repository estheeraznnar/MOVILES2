package org.iesch.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.w("CICLODEVIDA", "entramos en el metodo Otra activity")

        val boton = findViewById<Button>(R.id.btn_otra)
        boton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("CICLODEVIDA", "entramos en el metodo on start()")
    }

    override fun onResume() {
        super.onResume()
        Log.w("CICLODEVIDA", "entramos en el metodo on resume()")

    }

    override fun onPause() {
        super.onPause()
        Log.w("CICLODEVIDA", "entramos en el metodo on pause()")
    }

    override fun onStop() {
        super.onStop()
        Log.w("CICLODEVIDA", "entramos en el metodo on stop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("CICLODEVIDA", "entramos en el metodo on restart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("CICLODEVIDA", "entramos en el metodo on destroy()")
    }
}