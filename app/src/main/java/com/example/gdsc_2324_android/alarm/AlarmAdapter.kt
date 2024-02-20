package com.example.gdsc_2324_android.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.databinding.ItemAlarmBinding

class AlarmAdapter(private val posts: List<AlarmItem>) : RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(private val binding: ItemAlarmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: AlarmItem) {
            binding.tvCategory.text = post.category
            binding.tvExplain.text = post.explain
            binding.tvComment.text = post.comment
            binding.tvDate.text = post.date
            binding.tvTime.text = post.time
        }
    }
}
