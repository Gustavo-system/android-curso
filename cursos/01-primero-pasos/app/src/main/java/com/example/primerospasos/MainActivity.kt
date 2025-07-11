package com.example.primerospasos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private lateinit var titleOneActivity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        //titleOneActivity = findViewById<TextView>(R.id.titleOneActivity)
        //val buttonGo = findViewById<Button>(R.id.buttonFirstActivity)

        // navegar a otra activity
        /*buttonGo.setOnClickListener {
            navegarSegundaActivity()
        }*/

        // implementar un fragment al inicio del activity
        // desde xml se agrega: android:name="com.example.primerospasos.FirtsFragment"
        supportFragmentManager.commit {
            // colocamos para que las animaciones se mantengan
            setReorderingAllowed(true)

            // invocamos el fragmento para inyectarlo en el activity
            add(R.id.fragment_container_view_tag, FirtsFragment())
        }



        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

    }

    /*
    private fun navegarSegundaActivity() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("name", "Panfilo Gutierres")
        startActivityForResult(intent, 1)
        //startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                val nombre = data?.getStringExtra("nombre2")
                titleOneActivity.text = nombre
            }

        }
    }
    */
}