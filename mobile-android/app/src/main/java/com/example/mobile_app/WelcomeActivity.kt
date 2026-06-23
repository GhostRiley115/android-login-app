package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Criando variaveis para verificar se é o primeiro acesso ou se já está logado.
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val hasSeenWelcome = prefs.getBoolean("has_seen_welcome", false)

        //Cria a lógica da verificação do primeiro acesso.
        if (hasSeenWelcome){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_welcome)

        val btnIniciar = findViewById<Button>(R.id.botaoIniciar)

        btnIniciar.setOnClickListener {
            prefs.edit().putBoolean("has_seen_welcome", true).apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}