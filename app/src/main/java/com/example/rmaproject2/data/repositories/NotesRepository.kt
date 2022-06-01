package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.data.models.note.NoteEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface NotesRepository {
    fun getAll(): Observable<List<Note>>
    fun getAllByTitle(title: String): Observable<List<Note>>
    fun getAllByContent(content: String): Observable<List<Note>>
    fun getAllArchived(): Observable<List<Note>>
    fun deleteById(id: Long): Completable
    fun insert(noteEntity: NoteEntity): Completable
    fun updateNote(noteEntity: NoteEntity): Completable
}