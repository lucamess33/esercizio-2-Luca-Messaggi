package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var totalSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input: EditText = findViewById(R.id.input)
        val button: Button = findViewById(R.id.button)
        val output: TextView = findViewById(R.id.output)

        button.setOnClickListener {
            val inputText = input.text.toString()

            if (inputText.isNotEmpty()) {
                val number = inputText.toIntOrNull()

                if (number != null) {
                    if (number >= 6){
                        output.text = "Promosso"
                    }
                    else{
                        output.text = "Bocciato"
                    }

                }
                else {
                    output.text = "Inserisci un numero valido"
                }
            }
            else {
                output.text = "Per favore, inserisci un valore"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}