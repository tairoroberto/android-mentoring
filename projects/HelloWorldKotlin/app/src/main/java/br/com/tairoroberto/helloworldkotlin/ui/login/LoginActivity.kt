package br.com.tairoroberto.helloworldkotlin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import br.com.tairoroberto.helloworldkotlin.R
import br.com.tairoroberto.helloworldkotlin.ui.home.HomeActivity
import br.com.tairoroberto.helloworldkotlin.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private var btnLogin: AppCompatButton? = null
    private lateinit var btnRegister: AppCompatButton
    private val editTextEmail: EditText by lazy { findViewById(R.id.editTextEmail) }
    private val editTextPassword: EditText by lazy { findViewById(R.id.editTextPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnLogin?.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            if (email == "tairoroberto@gmail.com" && password == "12345678"){
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

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