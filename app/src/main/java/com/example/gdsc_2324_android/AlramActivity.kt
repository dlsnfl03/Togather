package com.example.gdsc_2324_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.databinding.ActivityAlramBinding

class AlramActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlramBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlramBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}