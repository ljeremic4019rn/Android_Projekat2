package com.example.rmaproject2.data.datasource.local

import androidx.room.*
import com.example.rmaproject2.data.models.note.NoteEntity
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
abstract class NoteDao {

    @Query("SELECT * FROM notes WHERE archived == '0' ")
    abstract fun getAll(): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE title LIKE :search OR content LIKE :search ")
    abstract fun getAllBySearch(search: String): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes")
    abstract fun getAllArchived(): Observable<List<NoteEntity>>

    @Insert( onConflict = OnConflictStrategy.REPLACE )//todo mozda jos
    abstract fun insert(noteEntity: NoteEntity): Completable

    @Query("UPDATE notes SET title = :title, content = :content  WHERE id == :id ")
    abstract fun update(id: Long, title: String, content: String): Completable

    @Query("UPDATE notes SET archived = :arch WHERE id == :id")
    abstract fun changeArchived(id: Long, arch: Boolean): Completable

    @Query("DELETE FROM notes WHERE id == :id")
    abstract fun deleteById(id: Long): Completable

    @Query("DELETE FROM notes")
    abstract fun deleteAll(): Completable



}