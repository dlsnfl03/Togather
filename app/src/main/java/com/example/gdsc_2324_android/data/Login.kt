package com.example.gdsc_2324_android.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


//로그인
data class LoginDTO(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String?,
    @SerializedName("userGroup")
    var userGroup: String= "DISABLED",
    @SerializedName("username")
    var username: String
):Serializable
