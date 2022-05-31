package com.example.rmaproject2.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rmaproject2.data.repositories.CourseRepository
import com.example.rmaproject2.presentation.contract.CourseContract
import com.example.rmaproject2.presentation.view.states.CourseState
import io.reactivex.disposables.CompositeDisposable

class CourseSharedViewModel (private val courseRepository: CourseRepository ) : ViewModel(), CourseContract.ViewModel   {

    private val subscriptions = CompositeDisposable()
    override val moviesState: MutableLiveData<CourseState> = MutableLiveData()

    override fun fetchAllCourses() {
        TODO("Not yet implemented")
    }

    override fun getAllCourses() {
        TODO("Not yet implemented")
    }

    override fun getByFilter(subject: String, professor: String, group: String, day: String) {
        TODO("Not yet implemented")
    }


}