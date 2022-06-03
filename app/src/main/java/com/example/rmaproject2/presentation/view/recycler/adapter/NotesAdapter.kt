package com.example.rmaproject2.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.presentation.view.recycler.diff.NotesDiffCallback
import com.example.rmaproject2.presentation.view.recycler.viewHolder.NoteViewHolder

class NotesAdapter (
    val archiveNote: (Long, Boolean) -> Unit ,
    val deleteById: (Long) -> Unit,
    val startEditActivity: (String, String, Long) -> Unit,
) : ListAdapter<Note, NoteViewHolder>(NotesDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemBinding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(
            itemBinding,
            {id, bool -> archiveNote(id, bool)},
            {id -> deleteById(id)},
            {text, content, id -> startEditActivity(text,content,id)},
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {//
        holder.bind(getItem(position))
    }
}