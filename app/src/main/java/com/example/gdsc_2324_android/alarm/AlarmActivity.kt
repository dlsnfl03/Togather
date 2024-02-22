package com.example.gdsc_2324_android.alarm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var alarmAdapter: AlarmAdapter
    private val alarmList = mutableListOf<AlarmItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // RecyclerView 설정
        recyclerView = binding.rvPosts
        recyclerView.layoutManager = LinearLayoutManager(this)
        alarmAdapter = AlarmAdapter(alarmList)
        recyclerView.adapter = alarmAdapter


        // 예시 데이터 추가
        addExampleData()
    }

    private fun addExampleData() {
        // 예시 데이터 추가 (이 부분을 실제 데이터 추가하는 코드로 대체해야 함)
        for (i in 1..10) {
            alarmList.add(
                AlarmItem(
                    "Category $i",
                    "Explanation $i",
                    "Comment $i",
                    "Date $i",
                    "Time $i"
                )
            )
        }
        alarmAdapter.notifyDataSetChanged()
    }
}
