package com.example.gdsc_2324_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.gdsc_2324_android.databinding.ActivityWriteBinding
import java.util.Locale.Category

class WriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 추정 나이 선택 스피너 설정
        val categorySpinner = binding.spnCategory	// spinner
        val categoryArray = resources.getStringArray(R.array.array_category)	// 배열
        setSpinner(categorySpinner, categoryArray)	// 스피너 설정


    }

    // 스피너 설정
    private fun setSpinner(spinner: Spinner, array: Array<String>) {
        val adapter = object : ArrayAdapter<String>(
            this@WriteActivity,
            android.R.layout.simple_dropdown_item_1line
        ) { override fun getCount(): Int =  super.getCount() - 1 }  // array에서 hint 안 보이게 하기
        adapter.addAll(array.toMutableList())   // 배열 추가
        spinner.adapter = adapter               // 어댑터 달기
        spinner.setSelection(adapter.count)     // 스피너 초기값=hint
    }


}