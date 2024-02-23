package com.example.gdsc_2324_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.Setting.SettingActivity
import com.example.gdsc_2324_android.databinding.ActivitySetGroupBinding

class SetGroupActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySetGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }
}