package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activityCadastro)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentHome = Intent(this,HomeActivity::class.java)

            val buttonCadastrar = findViewById<Button>(R.id.botaoCadastrar)
            buttonCadastrar.setOnClickListener {
                val senha1 = findViewById<EditText>(R.id.etCadastroSenha).text.toString()
                val senha2 = findViewById<EditText>(R.id.etCadastroConfirmarSenha).text.toString()
                if (senha1.equals(senha2) && senha1.isNotEmpty() && senha2.isNotEmpty()) {
                    Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_LONG).show()
                    startActivity(intentHome)
                }else if (!senha1.equals(senha2)) {
                        Toast.makeText(this, "As senhas não são iguais!", Toast.LENGTH_LONG).show()
                }else if (senha1.isEmpty() || senha2.isEmpty()) {
                    Toast.makeText(this, "O campo senha não pode estar vazio", Toast.LENGTH_LONG).show()
                }
            }
    }
}