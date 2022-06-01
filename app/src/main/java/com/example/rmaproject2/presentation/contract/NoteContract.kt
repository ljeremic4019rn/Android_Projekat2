package com.example.rmaproject2.presentation.contract

import androidx.lifecycle.LiveData
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.data.models.note.NoteEntity
import com.example.rmaproject2.presentation.view.states.CourseState
import com.example.rmaproject2.presentation.view.states.NoteState
import io.reactivex.Completable
import io.reactivex.Observable

interface NoteContract {
    interface ViewModel {
        val noteState: LiveData<NoteState>
//        val addDone: LiveData<AddMovieState> todo mozda
        fun getAll()
        fun getAllByTitle(title: String)
        fun getAllByContent(content: String)
        fun getAllArchived()
        fun deleteById(id: Long)
        fun insert(noteEntity: NoteEntity)
        fun updateNote(noteEntity: NoteEntity)
    }
}