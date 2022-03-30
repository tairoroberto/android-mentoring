package br.com.tairoroberto.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.tairoroberto.helloworldkotlin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextEmail.setText(intent.getStringExtra("EMAIL"))
        binding.editTextPassword.setText(intent.getStringExtra("PASSWORD"))


        binding.btnRegister.setOnClickListener {
            Log.i("TAG", "Email: ${binding.editTextEmail.text} -> Password: ${binding.editTextPassword.text}")
        }
    }
}