package com.example.gdsc_2324_android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class exbanner : AppCompatActivity() {

    private var numBanner = 3 // 배너 갯수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager_banner.adapter = ViewPagerAdapter(getBannerList())
        viewPager_banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        textView_total_banner.text = numBanner.toString()

        // 현재 몇 번째 배너인지 보여주는 숫자를 변경함
        viewPager_banner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                textView_current_banner.text = "${position + 1}" // position이 0부터 시작해서 +1
            }
        })

        linear_layout_see_all.setOnClickListener {
            Toast.makeText(this, "모두 보기 클릭했음", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    }
}
