package com.example.rmaproject2.presentation.contract

import androidx.lifecycle.LiveData
import com.example.rmaproject2.data.models.course.Course
import com.example.rmaproject2.presentation.view.states.CourseState
import io.reactivex.Observable

interface CourseContract {
    interface ViewModel {

        val moviesState: LiveData<CourseState>

        fun fetchAllCourses()
        fun getAllCourses()
        fun getByFilter(subject: String, professor: String, group: String, day: String)

    }
}