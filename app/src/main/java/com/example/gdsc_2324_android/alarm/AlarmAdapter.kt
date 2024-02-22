package com.example.gdsc_2324_android.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.example.gdsc_2324_android.R

class AlarmAdapter(private val alarmList: MutableList<AlarmItem>) :
    RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    inner class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.tv_category)
        val explainTextView: TextView = itemView.findViewById(R.id.tv_explain)
        val commentTextView: TextView = itemView.findViewById(R.id.tv_comment)
        val dateTextView: TextView = itemView.findViewById(R.id.tv_date)
        val timeTextView: TextView = itemView.findViewById(R.id.tv_time)
        val cancelImageButton: ImageButton = itemView.findViewById(R.id.btn_cancel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return AlarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val currentItem = alarmList[position]

        holder.categoryTextView.text = currentItem.category
        holder.explainTextView.text = currentItem.explain
        holder.commentTextView.text = currentItem.comment
        holder.dateTextView.text = currentItem.date
        holder.timeTextView.text = currentItem.time

        holder.cancelImageButton.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    private fun removeItem(position: Int){
        alarmList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }
}

