package br.com.tairoroberto.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    lateinit var btnLogin: AppCompatButton
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)

        btnLogin.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            Log.i("TAG", "FAZENDO LOGIN: my email -> $email my password -> $password")
        }
    }
}