package com.example.rmaproject2.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rmaproject2.databinding.ScheduleItemBinding
import com.example.rmaproject2.data.models.Schedule
import com.example.rmaproject2.presentation.view.recycler.diff.ScheduleDiffCallback
import com.example.rmaproject2.presentation.view.recycler.viewHolder.ScheduleViewHolder

class ScheduleAdapter : ListAdapter<Schedule, ScheduleViewHolder>(ScheduleDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemBinding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(itemBinding)    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}