package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.models.Resource
import com.example.rmaproject2.data.models.Course
import io.reactivex.Completable
import io.reactivex.Observable

interface CourseRepository {

    fun fetchAll(): Observable<Resource<Unit>> // fetch dovlaci sa interneta
    fun getAll(): Observable<List<Course>> // get dovlaci iz baze
    fun getAllByName(name: String): Observable<List<Course>>
    fun insert(course: Course): Completable
}