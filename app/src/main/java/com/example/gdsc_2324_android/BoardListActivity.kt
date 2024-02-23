package com.example.gdsc_2324_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.SignUp.StartActivity
import com.example.gdsc_2324_android.databinding.ActivityBoardListBinding

class BoardListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBoardListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }


}