package org.iesch.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boton = findViewById<Button>(R.id.btn_main)
        boton.setOnClickListener {
            val intent = Intent(this, OtraActivity::class.java)
            startActivity(intent)

        }

        Log.i("CICLODEVIDA", "entramos en el metodo Main()")


    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLODEVIDA", "entramos en el metodo on start()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLODEVIDA", "entramos en el metodo on resume()")

    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLODEVIDA", "entramos en el metodo on pause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLODEVIDA", "entramos en el metodo on stop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLODEVIDA", "entramos en el metodo on restart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLODEVIDA", "entramos en el metodo on destroy()")
    }

}