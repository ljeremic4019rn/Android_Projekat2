package com.example.rmaproject2.presentation.view.recycler.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.rmaproject2.databinding.ScheduleItemBinding
import com.example.rmaproject2.data.models.Schedule

class ScheduleViewHolder (private val itemBinding: ScheduleItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    fun bind(schedule: Schedule){
        itemBinding.subjectTv.text = schedule.subject
        itemBinding.typeTv.text = schedule.type
        itemBinding.professorTv.text = schedule.professor
        itemBinding.classroomTv.text = schedule.classroom
        itemBinding.groupTv.text = schedule.group
        itemBinding.dayTv.text = schedule.day
        itemBinding.timeTv.text = schedule.time
    }
}