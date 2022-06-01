package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.datasource.local.NoteDao
import com.example.rmaproject2.data.models.course.Course
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.data.models.note.NoteEntity
import io.reactivex.Completable
import io.reactivex.Observable

class NotesRepositoryImpl(private val localDataSource: NoteDao) : NotesRepository {

    override fun getAll(): Observable<List<Note>> {
        return localDataSource
            .getAll()
            .map { it ->
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.creationDate,
                        it.archived
                    )
                }
            }
    }

    override fun getAllByTitle(title: String): Observable<List<Note>> {

        val queryTitle: String = "%$title%"


        return localDataSource
            .getAllByTitle(queryTitle)
            .map { it ->
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.creationDate,
                        it.archived
                    )
                }
            }
    }

    override fun getAllByContent(content: String): Observable<List<Note>> {

        val queryContent: String = "%$content%"

        return localDataSource
            .getAllByContent(queryContent)
            .map { it ->
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.creationDate,
                        it.archived
                    )
                }
            }
    }

    override fun getAllArchived(): Observable<List<Note>> {
        return localDataSource
            .getAllArchived()
            .map { it ->
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.content,
                        it.creationDate,
                        it.archived
                    )
                }
            }
    }

    override fun deleteById(id: Long): Completable {
         return localDataSource.deleteById(id)
    }

    override fun insert(noteEntity: NoteEntity): Completable {
        return localDataSource.insert(noteEntity)
    }

    override fun updateNote(noteEntity: NoteEntity): Completable {
         return localDataSource.update(noteEntity)
    }

}