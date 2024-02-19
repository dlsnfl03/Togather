package com.example.gdsc_2324_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.databinding.ActivityBoardBinding


class Board: AppCompatActivity() {
    private lateinit var binding : ActivityBoardBinding
    private lateinit var replyAdapter:itemreplyadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 가상의 데이터
        val replyPost = getMockPopularPosts()

        // RecyclerView 설정
        replyAdapter = itemreplyadapter(replyPost)
        binding.replyre.layoutManager = LinearLayoutManager(this)
        binding.replyre.adapter = replyAdapter


        // 뒤로가기 클릭 시 이벤트
        binding.btn_re_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // 답글쓰기 클릭 시 이벤트
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.reply.setOnClickListener(View.OnClickListener {
            manager.showSoftInput(
                editText,
                InputMethodManager.SHOW_IMPLICIT
            )
        })

        // 댓글쓰기
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.btn_reply.setOnClickListener(View.OnClickListener {
            manager.showSoftInput(
                editText,
                InputMethodManager.SHOW_IMPLICIT
            )
        })



    }


    // 가상의 데이터 생성 함수
    private fun getMockPopularPosts(): List<itemreply> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 한다.

        //임시
        val mockPosts = mutableListOf<itemreply>()

        // 가상의 데이터 생성
        for (i in 1..3) {
            mockPosts.add(
                itemreply(
                    "익명 $i",
                    "내용 $i",
                    "Date $i",

                    )
            )
        }
        return mockPosts
    }
}