package com.example.gdsc_2324_android.retrofit

import com.example.gdsc_2324_android.api.LoginService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    //사용할 API 인터페이스 선언
    val loginApi: LoginService

    val gson: Gson = GsonBuilder().setLenient().create()

    init{
        //API 서버 연결
        val retrofit= Retrofit.Builder()
            .baseUrl("/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        loginApi=retrofit.create(LoginService::class.java)

    }}