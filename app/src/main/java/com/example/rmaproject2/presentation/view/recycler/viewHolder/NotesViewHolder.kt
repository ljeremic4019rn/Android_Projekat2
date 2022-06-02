package com.example.rmaproject2.presentation.view.recycler.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.rmaproject2.databinding.NoteItemBinding
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.fragments.NotesFragment

class NotesViewHolder(private val itemBinding: NoteItemBinding,/*onItemClicked: (Int) -> Unit ,*/private val noteViewModel: NoteContract.ViewModel, private val notesFragment: NotesFragment) : RecyclerView.ViewHolder(itemBinding.root) {



    init{
        itemBinding.archiveBtn.setOnClickListener{ //todo uradi call back metodu koja se vuce iz fragmenta
            val bool: Boolean = itemBinding.archived.text.toString() == "false"
            itemBinding.archived.text = bool.toString()
            noteViewModel.changeArchived(itemBinding.id.text.toString().toLong(), bool)
        }

//        itemBinding.archiveBtn.setOnClickListener{
////            onItemClicked.invoke()
//        }

        itemBinding.deleteBtn.setOnClickListener{
            noteViewModel.deleteById(itemBinding.id.text.toString().toLong())//
        }

        itemBinding.editBtn.setOnClickListener{
            notesFragment.startEditActivity(itemBinding.notesTitle.text.toString(), itemBinding.noteContent.text.toString(), itemBinding.id.text.toString().toLong())
        }
    }

    fun bind(note: Note){
        itemBinding.notesTitle.text = note.title
        itemBinding.noteContent.text = note.content
        itemBinding.id.text = note.id.toString()
        itemBinding.archived.text = note.archived.toString()
    }
}