package com.example.app_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activityHome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nome = intent.getStringExtra("nome")

        val titulo = findViewById<TextView>(R.id.textViewHome)
        titulo.text = "Olá, $nome"

        val intentBoleto = Intent(this,BoletoActivity::class.java)
        val buttonBoleto = findViewById<Button>(R.id.btnBoleto)
        buttonBoleto.setOnClickListener {
            startActivity(intentBoleto)
        }
    }
}