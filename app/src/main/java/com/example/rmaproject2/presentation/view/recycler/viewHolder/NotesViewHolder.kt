package com.example.rmaproject2.presentation.view.recycler.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note

class NotesViewHolder(private val itemBinding: NoteItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(note: Note){
        itemBinding.notesTitle.text = note.title
        itemBinding.noteContent.text = note.content
        itemBinding.id.text = note.id.toString()
        itemBinding.archived.text = note.archived.toString()
    }
}