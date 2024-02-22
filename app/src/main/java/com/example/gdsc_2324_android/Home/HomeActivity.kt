package com.example.gdsc_2324_android.Home

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.adapter.PopularPostAdapter
import com.example.gdsc_2324_android.Home.data.PopularPostItem
import com.example.gdsc_2324_android.MapActivity
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.Scrap.ScrapActivity
import com.example.gdsc_2324_android.Setting.SettingActivity
import com.example.gdsc_2324_android.Write.WriteActivity
import com.example.gdsc_2324_android.alarm.AlarmActivity
import com.example.gdsc_2324_android.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var popularPostAdapter: PopularPostAdapter

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_write -> {
                startActivity(Intent(this, WriteActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                startActivity(Intent(this, MapActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                // 현재 화면이 이미 홈 화면이므로 아무것도 하지 않음
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_scrap -> {
                startActivity(Intent(this, ScrapActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                startActivity(Intent(this, SettingActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // BottomNavigationView 초기화
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bnv_home)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        // 가상의 데이터
        val popularPosts = getMockPopularPosts()

        // 인기 게시글 - RecyclerView 설정
        popularPostAdapter = PopularPostAdapter(popularPosts)
        binding.rvPopularPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPopularPosts.adapter = popularPostAdapter

        // 더보기 클릭 시 이벤트
        binding.imgPopularMore.setOnClickListener {
            val intent = Intent(this, PopularMoreActivity::class.java)
            startActivity(intent)
        }
        binding.imgNotification.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }

        //소속 선택 - 다이얼로그 실행
        showDialog()
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_check_group)

        val radioGroup : RadioGroup = dialog.findViewById(R.id.radio_group)
        val dialogButton : Button = dialog.findViewById(R.id.dialog_button)

        dialogButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if(selectedId != -1){
                val radioButton:RadioButton = dialog.findViewById(selectedId)
                val selectedText : String = radioButton.text.toString()

                //여기서 선택된 값을 서버에 전송하도록 처리
                Toast.makeText(this@HomeActivity, "선택된 소속 : $selectedText", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }else{
                Toast.makeText(this@HomeActivity, "소속을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
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
