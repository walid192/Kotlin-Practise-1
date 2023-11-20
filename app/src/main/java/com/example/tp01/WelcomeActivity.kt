package com.example.tp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp01.databinding.ActivityMainBinding
import com.example.tp01.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)


        setContentView(binding.root)


        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        binding.welcomeText.text = "Bienvenue $email"

        var btn=binding.button2
        btn.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

    }
}