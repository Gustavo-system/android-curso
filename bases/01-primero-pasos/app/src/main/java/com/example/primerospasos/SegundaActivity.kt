package com.example.primerospasos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.primerospasos.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private var nombre : String? = ""
    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        setContentView(R.layout.activity_segunda)

        // declaramos una clase para variables
        Variables.name

        //val titulo = findViewById<TextView>(R.id.tituloSegundaActividad)
        //val buttonVolver = findViewById<Button>(R.id.buttonSegundaActivity)

        // usando binding
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        // para recibir valores de un activity
        intent.extras?.let { bundle: Bundle ->
            nombre = bundle.getString("name")
        }

        // usando los valores que se recibieron en el activity
        //titulo.text = nombre
        binding.tituloSegundaActividad.text = "perro"
        binding.tituloSegundaActividad.apply {
            text = ""
            textSize = 22f
        }

        binding.buttonSegundaActivity.setOnClickListener {
            // para devolver valores a otro activity
            val intent = Intent()
            intent.putExtra("nombre2", "Hello from Second Activity")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}