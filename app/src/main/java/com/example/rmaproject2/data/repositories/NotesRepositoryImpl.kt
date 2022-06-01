package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.datasource.local.NoteDao
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.data.models.note.NoteEntity
import io.reactivex.Completable
import io.reactivex.Observable

class NotesRepositoryImpl (private val localDataSource: NoteDao,) : NotesRepository {

    override fun getAll(): Observable<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getAllByName(name: String): Observable<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getAllByContent(name: String): Observable<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getAllArchived(): Observable<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun insert(noteEntity: NoteEntity): Completable {
        return localDataSource.insert(noteEntity)
    }

    override fun updateNote(noteEntity: NoteEntity): Completable {
        TODO("Not yet implemented")
    }

}