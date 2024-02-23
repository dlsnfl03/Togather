package com.example.gdsc_2324_android.Setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.ChangeNameActivity
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.Home.PopularMoreActivity
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.SetGroupActivity
import com.example.gdsc_2324_android.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뒤로가기
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.tvGroupChange.setOnClickListener {
            startActivity(Intent(this, SetGroupActivity::class.java))
        }
        binding.tvNameChange.setOnClickListener {
            startActivity(Intent(this, ChangeNameActivity::class.java))
        }
    }
}