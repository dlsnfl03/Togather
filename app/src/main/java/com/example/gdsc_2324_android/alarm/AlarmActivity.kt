package com.example.gdsc_2324_android.alarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlarmBinding
    private lateinit var alarmAdapter: AlarmAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 가상의 데이터
        val morePosts = getMockMorePosts()

        // RecyclerView 설정
        alarmAdapter = AlarmAdapter(morePosts)
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = alarmAdapter

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getMockMorePosts(): List<AlarmItem> {
        // 여기에서 실제 데이터를 가져와 PopularPostItem 객체들을 생성하여 반환
        // 이 부분은 실제 API 호출이나 데이터베이스 조회로 대체되어야 함.

        //임시
        val mockPosts = mutableListOf<AlarmItem>()

        // 가상의 데이터 생성
        for (i in 1..10) {
            mockPosts.add(
                AlarmItem(
                    "Title $i",
                    "Content $i",
                    "Writer $i",
                    "Date $i",
                    "Time $i",

                )
            )
        }
        return mockPosts
    }
}