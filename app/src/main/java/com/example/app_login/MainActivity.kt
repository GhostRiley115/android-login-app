package com.example.app_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainHome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentHome = Intent(this,HomeActivity::class.java)
        val intentCadastro = Intent(this,CadastroActivity::class.java)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if(email.equals("email@teste.com") && password.equals("123")){
                startActivity(intentHome)
                Toast.makeText(this, "Logado!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Login não encontrado, verifique as informações!",Toast.LENGTH_LONG).show()
            }
        }

        val buttonCadastro = findViewById<Button>(R.id.buttonCadastro)
        buttonCadastro.setOnClickListener {
            startActivity(intentCadastro)
        }
    }
}