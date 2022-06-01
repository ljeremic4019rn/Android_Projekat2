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

class NotesAdapter (private val noteViewModel: NoteContract.ViewModel, private val notesFragment: NotesFragment)  : ListAdapter<Note, NotesViewHolder>(NotesDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemBinding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        initListeners(itemBinding)//todo proveri da li je ovo dobro
        return NotesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun initListeners(itemBinding: NoteItemBinding){
        itemBinding.archiveBtn.setOnClickListener{
            val bool: Boolean = itemBinding.archived.text.toString() == "false"
            itemBinding.archived.text = bool.toString()
            noteViewModel.changeArchived(itemBinding.id.text.toString().toLong(), bool)
        }

        itemBinding.deleteBtn.setOnClickListener{
            noteViewModel.deleteById(itemBinding.id.text.toString().toLong())
        }

        itemBinding.editBtn.setOnClickListener{
            notesFragment.startEditActivity(itemBinding.notesTitle.text.toString(), itemBinding.noteContent.text.toString(), itemBinding.id.text.toString().toLong())
        }
    }

}