package com.example.rmaproject2.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.recycler.diff.NotesDiffCallback
import com.example.rmaproject2.presentation.view.recycler.viewHolder.NotesViewHolder

class NotesAdapter (noteViewModel: NoteContract.ViewModel)  : ListAdapter<Note, NotesViewHolder>(NotesDiffCallback()){

    private val localNoteViewModel: NoteContract.ViewModel = noteViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemBinding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        initListeners(itemBinding)

        return NotesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun initListeners(itemBinding: NoteItemBinding){

        itemBinding.archiveBtn.setOnClickListener{

            val bool: Boolean = itemBinding.archived.text.toString() == "false"
            itemBinding.archived.text = bool.toString()
            localNoteViewModel.chagneArchived(itemBinding.id.text.toString().toLong(), bool)
        }

        itemBinding.deleteBtn.setOnClickListener{
            localNoteViewModel.deleteById(itemBinding.id.text.toString().toLong())
        }

        itemBinding.editBtn.setOnClickListener{
            //todo
        }
    }
}