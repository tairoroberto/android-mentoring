package br.com.tairoroberto.helloworldkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    private val btnLogin: AppCompatButton by lazy { findViewById(R.id.btnLogin) }
    private val btnRegister: AppCompatButton by lazy { findViewById(R.id.btnRegister) }
    private val editTextEmail: EditText by lazy { findViewById(R.id.editTextEmail) }
    private val editTextPassword: EditText by lazy { findViewById(R.id.editTextPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegister.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            val intent  = Intent(this, RegisterActivity::class.java).apply {
                putExtra("EMAIL", email)
                putExtra("PASSWORD", password)
            }

            startActivity(intent)
        }
    }
}