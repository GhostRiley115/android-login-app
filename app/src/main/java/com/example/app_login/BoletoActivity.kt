package com.example.app_login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BoletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boleto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boletos = listOf(
            Boleto("Taxa Condominio Maio", "R$ 1500", "18/05/2026"),
            Boleto("Taxa Condominio Maio", "R$ 1500", "18/05/2026"),
            Boleto("Taxa Condominio Maio", "R$ 1500", "18/05/2026"),
        )

        val rc = findViewById<RecyclerView>(R.id.recyclerView)
        rc.layoutManager = LinearLayoutManager(this)
        rc.adapter = BoletoAdapter(boletos)
    }
}