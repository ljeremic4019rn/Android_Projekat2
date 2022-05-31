package com.example.rmaproject2.presentation.view.states

import org.jetbrains.annotations.Async

sealed class
CourseState {
    object Loading: CourseState()
    object DataFetched: CourseState()
    data class Success(val movies: List<Async.Schedule>): CourseState()
    data class Error(val message: String): CourseState()
}