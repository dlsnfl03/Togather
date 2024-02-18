package com.example.gdsc_2324_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class boardlistAdapter (private val boards: List<boarditem>) : RecyclerView.Adapter<boardlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = boarditemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val board = boards[position]
        holder.bind(board)
    }

    override fun getItemCount(): Int {
        return boards.size
    }

    class ViewHolder(private val binding: boarditemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: boarditem) {
            binding.bdtitle.text=board.bdtitle
            binding.bdcontent.text = board.bdcontent
            binding.bdwriter.text = board.bdwriter
            binding.bdtime.text = board.bdtime

        }
    }
