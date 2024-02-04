package com.example.gdsc_2324_android.Home

// MoreActivity.kt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.adapter.PopularPostAdapter
import com.example.gdsc_2324_android.Home.data.PopularPostItem
import com.example.gdsc_2324_android.databinding.ActivityPopularMoreBinding


class PopularMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopularMoreBinding
    private lateinit var popularPostAdapter: PopularPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 가상의 데이터
        val morePosts = getMockMorePosts()

        // RecyclerView 설정
        popularPostAdapter = PopularPostAdapter(morePosts)
        binding.rvMorePosts.layoutManager = LinearLayoutManager(this)
        binding.rvMorePosts.adapter = popularPostAdapter

        // 더보기 클릭 시 이벤트
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    // 가상의 데이터 생성 함수
    private fun getMockMorePosts(): List<PopularPostItem> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 함.

        //임시
        val mockPosts = mutableListOf<PopularPostItem>()

        // 가상의 데이터 생성
        for (i in 1..10) {
            mockPosts.add(
                PopularPostItem(
                    "Title $i",
                    "Content $i",
                    "Writer $i",
                    "Date $i",
                    "Time $i",
                    10, // Like count
                    5   // Comment count
                )
            )
        }
        return mockPosts
    }
}
