package com.example.gdsc_2324_android.SignUp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.Login.LoginActivity
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.databinding.ActivityStartBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task


class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)

        //account가 null인 경우  : 로그인되지 않았습니다.
        //account가 null이 아닌 경우 : 로그인 되었습니다.
        account?.let {
            Toast.makeText(this, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
        } ?: Toast.makeText(this, "로그인 되지 않았습니다", Toast.LENGTH_SHORT).show()

        /* 계정이 존재하면 자동으로 HomeActivity로 이동
        if (account != null) {
            moveToHomeActivity()
        }*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setResultSignUp()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        with(binding) {
            btnGoogle.setOnClickListener {
                signIn()
            }
            btnGoggleLogout.setOnClickListener {
                signOut()
            }
            btnInfo.setOnClickListener {
                GetCurrentUserProfile()
            }
            txtLogin.setOnClickListener {
                moveToLoginActivity()
            }
            txtSignup.setOnClickListener {
                moveToSignupEmail()
            }

        }
    }


    private fun setResultSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                //정상적으로 결과가 받아와진다면 조건문 실행
                if (result.resultCode == Activity.RESULT_OK) {
                    val task: Task<GoogleSignInAccount> =
                        GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleSignInResult(task)
                }
            }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val email = account?.email.toString()
            val familyName = account?.familyName.toString()
            val givenName = account?.givenName.toString()
            val displayName = account?.displayName.toString()
            val photoUrl = account?.photoUrl.toString()

            Log.d("로그인한 유저의 이메일", email)
            Log.d("로그인한 유저의 성", familyName)
            Log.d("로그인한 유저의 이름", givenName)
            Log.d("로그인한 유저의 전체이름", displayName)
            Log.d("로그인한 유저의 프로필 사진의 주소", photoUrl)

            //HomeActivity로 이동
            moveToHomeActivity()

        } catch (e: ApiException) {
            //apiException 상태 : 로그인 실패한 이유
            Log.w("failed", "signInResult:failed code=" + e.statusCode)
        }
    }


    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                //...
            }
    }

    private fun revokeAccess() {
        mGoogleSignInClient.revokeAccess()
            .addOnCompleteListener(this) {

            }
    }

    private fun GetCurrentUserProfile() {
        val curUser = GoogleSignIn.getLastSignedInAccount(this)
        curUser?.let {
            val email = curUser.email.toString()
            val familyName = curUser.familyName.toString()
            val givenName = curUser.givenName.toString()
            val displayName = curUser.displayName.toString()
            val photoUrl = curUser.photoUrl.toString()

            Log.d("현재 로그인 되어있는 유저의 이메일", email)
            Log.d("현재 로그인 되어있는 유저의 성", familyName)
            Log.d("현재 로그인 되어있는 유저의 이름", givenName)
            Log.d("현재 로그인 되어있는 유저의 전체이름", displayName)
            Log.d("현재 로그인 되어있는 유저의 프로필 사진의 주소", photoUrl)

        }
    }

    private fun moveToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // StartActivity를 종료하여 뒤로 가기 버튼으로 다시 돌아오지 않도록 함
    }

    private fun moveToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun moveToSignupEmail() {
        val intent = Intent(this, SignUpEmailActivity::class.java)
        startActivity(intent)
    }


}