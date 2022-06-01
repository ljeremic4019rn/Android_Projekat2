package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.models.course.Course
import com.example.rmaproject2.data.models.Resource
import io.reactivex.Observable

interface CourseRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<List<Course>>
    fun getByFilter(subjectOrProfessor: String, group: String, day: String): Observable<List<Course>>
}