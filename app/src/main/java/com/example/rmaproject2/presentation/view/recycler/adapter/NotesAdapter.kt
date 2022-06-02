package com.example.rmaproject2.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.fragments.NotesFragment
import com.example.rmaproject2.presentation.view.recycler.diff.NotesDiffCallback
import com.example.rmaproject2.presentation.view.recycler.viewHolder.NotesViewHolder

class NotesAdapter (private val noteViewModel: NoteContract.ViewModel, private val notesFragment: NotesFragment) : ListAdapter<Note, NotesViewHolder>(NotesDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemBinding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(itemBinding, noteViewModel, notesFragment)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {//
        holder.bind(getItem(position))
    }
}