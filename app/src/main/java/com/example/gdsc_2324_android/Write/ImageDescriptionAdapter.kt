package com.example.gdsc_2324_android.Write

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.R

class ImageDescriptionAdapter(private val context: Context) :
    RecyclerView.Adapter<ImageDescriptionAdapter.ImageDescriptionViewHolder>() {

    private val imageDescriptions: MutableList<Pair<Bitmap, String>> = mutableListOf()

    inner class ImageDescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val editTextImageDescription: EditText = itemView.findViewById(R.id.editTextImageDescription)
        val btnCancel: ImageButton = itemView.findViewById(R.id.btn_cancel) // 취소 버튼
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDescriptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image_with_description, parent, false)
        return ImageDescriptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageDescriptionViewHolder, position: Int) {
        val (bitmap, description) = imageDescriptions[position]
        holder.imageView.setImageBitmap(bitmap)
        holder.editTextImageDescription.setText(description)

        // 취소 버튼 클릭 이벤트 처리
        holder.btnCancel.setOnClickListener {
            removeItem(position) // 해당 위치의 항목 제거
        }
    }

    override fun getItemCount(): Int {
        return imageDescriptions.size
    }

    fun addImage(bitmap: Bitmap, description: String) {
        imageDescriptions.add(Pair(bitmap, description))
        notifyDataSetChanged()
    }

    // 항목 제거 함수
    private fun removeItem(position: Int) {
        imageDescriptions.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }
}
