package com.example.rmaproject2.presentation.view.recycler.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.fragments.NotesFragment

class NotesViewHolder(
    private val itemBinding: NoteItemBinding,
    val archiveNote: (Long, Boolean) -> Unit,
    val deleteById: (Long) -> Unit,
    val startEditActivity: (String, String, Long) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    init{
        itemBinding.archiveBtn.setOnClickListener{
            val bool: Boolean = itemBinding.archived.text.toString() == "false"
            itemBinding.archived.text = bool.toString()
//            noteViewModel.changeArchived(itemBinding.id.text.toString().toLong(), bool)
            archiveNote(itemBinding.id.text.toString().toLong(), bool)
        }

        itemBinding.deleteBtn.setOnClickListener{
//            noteViewModel.deleteById(itemBinding.id.text.toString().toLong())//
            deleteById(itemBinding.id.text.toString().toLong())
        }

        itemBinding.editBtn.setOnClickListener{
//            notesFragment.startEditActivity(itemBinding.notesTitle.text.toString(), itemBinding.noteContent.text.toString(), itemBinding.id.text.toString().toLong())
            startEditActivity(itemBinding.notesTitle.text.toString(), itemBinding.noteContent.text.toString(), itemBinding.id.text.toString().toLong())

        }
    }

    fun bind(note: Note){
        itemBinding.notesTitle.text = note.title
        itemBinding.noteContent.text = note.content
        itemBinding.id.text = note.id.toString()
        itemBinding.archived.text = note.archived.toString()
    }
}