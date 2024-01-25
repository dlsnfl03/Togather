package com.example.gdsc_2324_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.databinding.ActivitySignUpEmailBinding

class SignUpEmailActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}