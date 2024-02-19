package com.example.gdsc_2324_android.FindPw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.databinding.ActivityFindPwBinding

class FindPwActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFindPwBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPwBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}