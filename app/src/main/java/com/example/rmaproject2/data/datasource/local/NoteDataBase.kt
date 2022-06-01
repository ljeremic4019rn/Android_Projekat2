package com.example.rmaproject2.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rmaproject2.data.models.note.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class NoteDataBase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}