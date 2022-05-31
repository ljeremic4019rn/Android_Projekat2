package com.example.rmaproject2.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rmaproject2.data.models.course.Resource
import com.example.rmaproject2.data.repositories.CourseRepository
import com.example.rmaproject2.presentation.contract.CourseContract
import com.example.rmaproject2.presentation.view.states.CourseState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import java.util.concurrent.TimeUnit

class CourseViewModel (private val courseRepository: CourseRepository ) : ViewModel(), CourseContract.ViewModel   {

    private val subscriptions = CompositeDisposable()
    override val moviesState: MutableLiveData<CourseState> = MutableLiveData()
//    private val publishSubject: PublishSubject<String> = PublishSubject.create()


//    init {
//        val subscription = publishSubject
//            .debounce(200, TimeUnit.MILLISECONDS)
//            .distinctUntilChanged()
//            .switchMap {
//                courseRepository
//                    .getAll(it)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .doOnError {
//                        Timber.e("Error in publish subject")
//                        Timber.e(it)
//                    }
//            }
//            .subscribe(
//                {
//                    moviesState.value = CourseState.Success(it)
//                },
//                {
//                    moviesState.value = CourseState.Error("Error happened while fetching data from db")
//                    Timber.e(it)
//                }
//            )
//        subscriptions.add(subscription)
//    }

    override fun fetchAllCourses() {
        val subscription = courseRepository
            .fetchAll()
            .startWith(Resource.Loading()) //Kada se pokrene fetch hocemo da postavimo stanje na Loading
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is Resource.Loading -> moviesState.value = CourseState.Loading
                        is Resource.Success -> moviesState.value = CourseState.DataFetched
                        is Resource.Error -> moviesState.value = CourseState.Error("Error happened while fetching data from the server")
                    }
                },
                {
                    moviesState.value = CourseState.Error("Error happened while fetching data from the server")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllCourses() {
        val subscription = courseRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    moviesState.value = CourseState.Success(it)
                },
                {
                    moviesState.value = CourseState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByFilter(subject: String, professor: String, group: String, day: String) {
        TODO("Not yet implemented")
    }


}