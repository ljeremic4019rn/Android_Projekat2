package com.example.rmaproject2.data.datasource.remote

import androidx.room.Database
import androidx.room.TypeConverters
import com.example.rmaproject2.data.models.Course

@Database(
    entities = [Course::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
class CourseDataBase {
}