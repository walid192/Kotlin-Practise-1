package com.example.tp01

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var txtEmail : EditText
    lateinit var password : EditText
    lateinit var btnLogin : Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtEmail=binding.editTextTextEmailAddress
        password=binding.editTextTextPassword

        btnLogin=binding.cnxbutton

        val duration = Toast.LENGTH_SHORT
        val correctEmail = "gl4@insat.tn"
        val correctPassword = "insat2022"



        btnLogin.setOnClickListener {
            var email = txtEmail.text.toString()
            var pass = password.text.toString()
            val intent = Intent(this, WelcomeActivity::class.java)

            if (email != correctEmail || pass != correctPassword) {
                showToast("Email ou mot de passe incorrect")
            }
            else {
                intent.putExtra("email", email)
                intent.putExtra("password", pass)
                startActivity(intent)
            }

        }

    }
    private fun showToast(message: String) {
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(this, message, duration).show()
    }
}