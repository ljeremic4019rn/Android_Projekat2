package com.example.rmaproject2.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.rmaproject2.data.models.Schedule

class ScheduleDiffCallback : DiffUtil.ItemCallback<Schedule>(){

    override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return  oldItem.subject == newItem.subject &&
                oldItem.type == newItem.type &&
                oldItem.professor == newItem.professor &&
                oldItem.classroom == newItem.classroom &&
                oldItem.group == newItem.group &&
                oldItem.day == newItem.day &&
                oldItem.time == newItem.time
    }
}