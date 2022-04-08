package br.com.tairoroberto.helloworldkotlin.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.tairoroberto.helloworldkotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, MovieFragment())
            .commit()
    }
}