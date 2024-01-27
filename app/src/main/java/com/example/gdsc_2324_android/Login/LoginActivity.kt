package com.example.gdsc_2324_android.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}