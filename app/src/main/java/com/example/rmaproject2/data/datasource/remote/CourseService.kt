package com.example.rmaproject2.data.datasource.remote

import com.example.rmaproject2.data.models.course.Course
import com.example.rmaproject2.data.models.course.CourseResponse
import io.reactivex.Observable
import retrofit2.http.*


interface  CourseService {
    @GET
    fun getAll(): Observable<List<CourseResponse>>
}