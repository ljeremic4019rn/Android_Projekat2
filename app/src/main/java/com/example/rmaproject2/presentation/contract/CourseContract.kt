package com.example.rmaproject2.presentation.contract

import androidx.lifecycle.LiveData
import com.example.rmaproject2.presentation.view.states.CourseState

interface CourseContract {
    interface ViewModel {

        val moviesState: LiveData<CourseState>

        fun fetchAllCourses()
        fun getAllCourses()
        fun getByProfessor(name: String)
        fun getBySubject(name: String)
        fun getByGroup(name: String)
        fun getByDay(name: String)
    }
}