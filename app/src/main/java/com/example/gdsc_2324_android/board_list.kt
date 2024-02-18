package com.example.gdsc_2324_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.databinding.ActivityBoardListBinding


class board_list: AppCompatActivity() {
    private lateinit var binding :ActivityBoardListBinding
    private lateinit var boardAdapter:boardlistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 가상의 데이터
        val boardPost = getMockPopularPosts()

        // RecyclerView 설정
        boardAdapter= boardlistAdapter(boardPost)
        binding.boardre.layoutManager = LinearLayoutManager(this)
        binding.boardre.adapter = boardAdapter


        // 뒤로가기 클릭 시 이벤트
        binding.btnbdback.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }


    // 가상의 데이터 생성 함수
    private fun getMockPopularPosts(): List<boarditem> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 한다.

        //임시
        val mockPosts = mutableListOf<boarditem>()

        // 가상의 데이터 생성
        for (i in 1..3) {
            mockPosts.add(
                boarditem(
                    "제목 $i",
                    "내용 $i",
                    "작성자 $i",
                    "Date $i",

                )
            )
        }
        return mockPosts
    }
}