package com.example.gdsc_2324_android.Home.data

// PopularPostItem.kt
data class PopularPostItem(
    val title: String,
    val content: String,
    val writer: String,
    val date: String,
    val time: String,
    val likeCount: Int,
    val commentCount: Int
)

