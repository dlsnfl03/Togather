package com.example.gdsc_2324_android

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_2324_android.Home.HomeActivity
import com.example.gdsc_2324_android.databinding.ActivityBoardBinding
import com.example.gdsc_2324_android.databinding.ActivityBoardListBinding


class itemreplyadapter (private val replys: List<itemreply>) : RecyclerView.Adapter<boardlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = itemreplyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reply = replys[position]
        holder.bind(reply)
    }

    override fun getItemCount(): Int {
        return replys.size
    }


    class ViewHolder(private val binding: itemreplyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(reply: itemreply) {
            binding.name.text=reply.text
            binding.replycontent.text = reply.replycontent
            binding.time.text = reply.time

        }
    }
