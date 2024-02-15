package com.example.gdsc_2324_android.Setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.databinding.ActivitySettingGroupBinding

class SettingGroupActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}