package com.example.gdsc_2324_android.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.databinding.ActivityStartBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope

//구글로그인 파이어베이스 연동해서 하기

class StartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStartBinding
    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var resultLauncher : ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setResultSignUp()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)

        //account가 null인 경우  : 로그인되지 않았습니다.
        //account가 null이 아닌 경우 : 로그인 되었습니다.
        account?.let{
            Toast.makeText(this, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
        } ?: Toast.makeText(this, "로그인 되지 않았습니다", Toast.LENGTH_SHORT).show()
    }


    private fun setResultSignUp(){

    }



}