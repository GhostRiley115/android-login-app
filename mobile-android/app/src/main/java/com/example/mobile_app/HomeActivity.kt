package com.example.mobile_app

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

        val intentReserva = Intent(this,ReservaActivity::class.java)
        val buttonReserva = findViewById<Button>(R.id.btnReserva)
        buttonReserva.setOnClickListener {
            startActivity(intentReserva)
        }

        val intentAutorizacao = Intent(this,AutorizacaoActivity::class.java)
        val buttonAutorizacao = findViewById<Button>(R.id.btnAutorizacao)
        buttonAutorizacao.setOnClickListener {
            startActivity(intentAutorizacao)
        }

        val intentMural = Intent(this,MuralActivity::class.java)
        val buttonMural = findViewById<Button>(R.id.btnMural)
        buttonMural.setOnClickListener {
            startActivity(intentMural)
        }

        val intentMudanca = Intent(this,MudancaActivity::class.java)
        val buttonMudanca = findViewById<Button>(R.id.btnMudanca)
        buttonMudanca.setOnClickListener {
            startActivity(intentMudanca)
        }

        val intentContatos = Intent(this,ContatosActivity::class.java)
        val buttonContatos = findViewById<Button>(R.id.btnContatos)
        buttonContatos.setOnClickListener {
            startActivity(intentContatos)
        }

        val intentPrestacao = Intent(this,PrestacaoActivity::class.java)
        val buttonPrestacao = findViewById<Button>(R.id.btnPrestacao)
        buttonPrestacao.setOnClickListener {
            startActivity(intentPrestacao)
        }
    }
}