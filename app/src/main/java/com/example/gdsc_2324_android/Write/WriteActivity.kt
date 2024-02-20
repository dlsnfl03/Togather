package com.example.gdsc_2324_android.Write

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.databinding.ActivityWriteBinding
import java.io.ByteArrayOutputStream

class WriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWriteBinding
    private lateinit var imageAdapter: ImageDescriptionAdapter
    private val selectedImages: MutableList<Pair<Bitmap, String>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //[스피너]
        //선택 스피너 설정
        val categorySpinner = binding.spnCategory	// spinner
        val categoryArray = resources.getStringArray(R.array.array_category)	// 배열
        setSpinner(categorySpinner, categoryArray)	// 스피너 설정

        imageAdapter = ImageDescriptionAdapter(this)
        binding.recyclerViewImages.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewImages.adapter = imageAdapter



        //뒤로가기
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        //이미지 추가하기
        binding.btnAttachImage.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
        }
        binding.btnRegister.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val content = binding.edtContent.text.toString()
            val category = categoryArray[binding.spnCategory.selectedItemPosition]

            // 서버에 게시글 데이터 전송 - retrofit 추가하기
            sendDataToServer(title, content, category, selectedImages)

        }


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

    //이미지 추가
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            val imageUri = data.data
            val inputStream = contentResolver.openInputStream(imageUri!!)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val description = "" // 사용자가 이미지 설명을 입력하도록 하는 부분

            // RecyclerView에 이미지 추가
            imageAdapter.addImage(bitmap, description)
            // 선택된 이미지 목록에 추가
            selectedImages.add(Pair(bitmap, description))
        }
    }

    // 서버로 게시글 데이터 전송
    private fun sendDataToServer(title: String, content: String, category: String, images: List<Pair<Bitmap, String>>) {
        // 이미지를 Base64로 인코딩하여 서버로 전송하는 코드 작성
        // 이 부분은 실제 서버와 통신하는 방법에 따라 다르므로 예시로만 제공
        // Retrofit, Volley 등의 라이브러리를 사용하여 HTTP 요청을 보내거나
        // 직접 HttpUrlConnection 등을 사용하여 요청을 보낼 수 있음
        // 이 예제에서는 간단히 이미지를 Base64로 인코딩하여 로그로 출력하는 것으로 대체
        Log.d("WriteActivity", "Title: $title, Content: $content, Category: $category")
        for (image in images) {
            val encodedImage = encodeImageToBase64(image.first)
            Log.d("WriteActivity", "Image: $encodedImage, Description: ${image.second}")
        }
    }

    // 이미지를 Base64로 인코딩하는 함수
    private fun encodeImageToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

}