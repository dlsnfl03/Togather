package com.example.gdsc_2324_android.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.adapter.PopularPostAdapter
import com.example.gdsc_2324_android.Home.data.PopularPostItem
import com.example.gdsc_2324_android.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var popularPostAdapter: PopularPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 가상의 데이터
        val popularPosts = getMockPopularPosts()

        // RecyclerView 설정
        popularPostAdapter = PopularPostAdapter(popularPosts)
        binding.rvPopularPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPopularPosts.adapter = popularPostAdapter

        // 더보기 클릭 시 이벤트
        binding.imgPopularMore.setOnClickListener {
            val intent = Intent(this, PopularMoreActivity::class.java)
            startActivity(intent)
        }
    }

    // 가상의 데이터 생성 함수
    private fun getMockPopularPosts(): List<PopularPostItem> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 한다.

        //임시
        val mockPosts = mutableListOf<PopularPostItem>()

        // 가상의 데이터 생성
        for (i in 1..3) {
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
