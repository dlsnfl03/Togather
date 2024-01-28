package com.example.gdsc_2324_android.Home.adapter

// PopularPostAdapter.kt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.Home.data.PopularPostItem
import com.example.gdsc_2324_android.databinding.ItemHomePopularPostBinding


class PopularPostAdapter(private val posts: List<PopularPostItem>) : RecyclerView.Adapter<PopularPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomePopularPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(private val binding: ItemHomePopularPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PopularPostItem) {
            binding.tvTitle.text = post.title
            binding.tvContent.text = post.content
            binding.tvWriter.text = post.writer
            binding.tvDate.text = post.date
            binding.tvTime.text = post.time
            binding.tvLikeNum.text = post.likeCount.toString()
            binding.tvChatNum.text = post.commentCount.toString()
            // additional operations if needed
        }
    }
}

