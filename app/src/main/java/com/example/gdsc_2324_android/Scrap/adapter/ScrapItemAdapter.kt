package com.example.gdsc_2324_android.Scrap.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.Scrap.data.ScrapItem
import com.example.gdsc_2324_android.databinding.ItemScrapBinding

class ScrapItemAdapter(private val scraps: List<ScrapItem>) : RecyclerView.Adapter<ScrapItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemScrapBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scrap = scraps[position]
        holder.bind(scrap)
    }

    override fun getItemCount(): Int {
        return scraps.size
    }

    class ViewHolder(private val binding: ItemScrapBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(scrap: ScrapItem) {
            binding.tvCategory.text=scrap.category
            binding.tvTitle.text = scrap.title
            binding.tvContent.text = scrap.content
            binding.tvDate.text = scrap.date
            binding.tvTime.text = scrap.time
            binding.tvLikeNum.text = scrap.likeCount.toString()
            binding.tvChatNum.text = scrap.commentCount.toString()
            // additional operations if needed
        }
    }
}