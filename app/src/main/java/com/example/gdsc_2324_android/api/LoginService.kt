package com.example.gdsc_2324_android.api

import com.example.gdsc_2324_android.data.LoginDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {

    //회원가입
    @POST("/api/users/login")
    fun login(
        @Body login: LoginDTO
    ): Call<Void>
}