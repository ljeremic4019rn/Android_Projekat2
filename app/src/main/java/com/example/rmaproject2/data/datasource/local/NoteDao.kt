package com.example.rmaproject2.data.datasource.local

import androidx.room.*
import com.example.rmaproject2.data.models.note.NoteEntity
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
abstract class NoteDao {

    @Query("SELECT * FROM notes")
    abstract fun getAll(): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE title LIKE :search OR content LIKE :search ")
    abstract fun getAllBySearch(search: String): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE archived == '1' ")
    abstract fun getAllArchived(): Observable<List<NoteEntity>>

    @Insert( onConflict = OnConflictStrategy.REPLACE )//todo mozda jos
    abstract fun insert(noteEntity: NoteEntity): Completable

    @Update
    abstract fun update(noteEntity: NoteEntity): Completable

    @Query("UPDATE notes SET archived = :arch WHERE id == :id")
    abstract fun changeArchived(id: Long, arch: Boolean): Completable

    @Query("DELETE FROM notes WHERE id == :id")
    abstract fun deleteById(id: Long): Completable

    @Query("DELETE FROM notes")
    abstract fun deleteAll(): Completable



}