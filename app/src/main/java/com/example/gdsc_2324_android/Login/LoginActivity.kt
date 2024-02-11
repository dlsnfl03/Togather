package com.example.gdsc_2324_android.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_2324_android.FindPw.FindPwActivity
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.SignUp.SignUpEmailActivity
import com.example.gdsc_2324_android.SignUp.StartActivity
import com.example.gdsc_2324_android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnBack.setOnClickListener {
                moveToStart()
            }
            tvFindPw.setOnClickListener {
                moveToFindPW()
            }
            tvSignup.setOnClickListener {
                moveToSignUp()
            }
        }
    }

    //start로
    private fun moveToStart() {
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }

    //비밀번호 찾기
    private fun moveToFindPW() {
        val intent = Intent(this, FindPwActivity::class.java)
        startActivity(intent)
    }

    private fun moveToSignUp() {
        val intent = Intent(this, SignUpEmailActivity::class.java)
        startActivity(intent)
    }
}