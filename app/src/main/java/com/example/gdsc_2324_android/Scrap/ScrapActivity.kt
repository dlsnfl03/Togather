package com.example.gdsc_2324_android.Scrap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.Home.PopularMoreActivity
import com.example.gdsc_2324_android.Home.adapter.PopularPostAdapter
import com.example.gdsc_2324_android.Home.data.PopularPostItem
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.Scrap.adapter.ScrapItemAdapter
import com.example.gdsc_2324_android.Scrap.data.ScrapItem
import com.example.gdsc_2324_android.databinding.ActivityScrapBinding

class ScrapActivity : AppCompatActivity() {
    private lateinit var binding :ActivityScrapBinding
    private lateinit var scrapAdapter:ScrapItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 추정 나이 선택 스피너 설정
        val categorySpinner = binding.spnCategory	// spinner
        val categoryArray = resources.getStringArray(R.array.array_category)	// 배열
        setSpinner(categorySpinner, categoryArray)	// 스피너 설정

        // 가상의 데이터
        val scrapPost = getMockPopularPosts()

        // RecyclerView 설정
        scrapAdapter = ScrapItemAdapter(scrapPost)
        binding.rvScrap.layoutManager = LinearLayoutManager(this)
        binding.rvScrap.adapter = scrapAdapter

        // 뒤로가기 클릭 시 이벤트
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    // 스피너 설정 : 전체 게시판 보이도록 수정해야 한다.
    private fun setSpinner(spinner: Spinner, array: Array<String>) {
        val adapter = object : ArrayAdapter<String>(
            this@ScrapActivity,
            android.R.layout.simple_dropdown_item_1line
        ) { override fun getCount(): Int =  super.getCount() -1 }  // array에서 hint 안 보이게 하기
        adapter.addAll(array.toMutableList())   // 배열 추가
        spinner.adapter = adapter               // 어댑터 달기
        spinner.setSelection(adapter.count)     // 스피너 초기값=hint
    }

    // 가상의 데이터 생성 함수
    private fun getMockPopularPosts(): List<ScrapItem> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 한다.

        //임시
        val mockPosts = mutableListOf<ScrapItem>()

        // 가상의 데이터 생성
        for (i in 1..3) {
            mockPosts.add(
                ScrapItem(
                    "취업 $i",
                    "Title $i",
                    "Content $i",
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