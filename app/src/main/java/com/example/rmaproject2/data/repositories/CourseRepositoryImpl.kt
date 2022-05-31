package com.example.rmaproject2.data.repositories

import com.example.rmaproject2.data.datasource.local.CourseDao
import com.example.rmaproject2.data.datasource.remote.CourseService
import com.example.rmaproject2.data.models.course.CourseEntity
import com.example.rmaproject2.data.models.course.Course
import com.example.rmaproject2.data.models.course.Resource
import io.reactivex.Observable
import timber.log.Timber

class CourseRepositoryImpl (
    private val localDataSource: CourseDao,
    private val remoteDataSource: CourseService
) : CourseRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext { it ->
                Timber.e("Upis u bazu")
                val entities = it.map { courseResponse ->
                    CourseEntity(
                        id = 0,
                        subject = courseResponse.predmet,
                        type = courseResponse.tip,
                        professor = courseResponse.nastavnik,
                        group = courseResponse.grupe,
                        day = courseResponse.dan,
                        time = courseResponse.termin,
                        classroom = courseResponse.ucionica
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

    override fun getAll(): Observable<List<Course>> {
        return localDataSource
            .getAll()
            .map { it ->
                it.map {
                    Course(it.id, it.subject, it.type, it.professor, it.classroom, it.group, it.day, it.time)
                }
            }
    }

    override fun getByFilter(
        subject: String,
        professor: String,
        group: String,
        day: String
    ): Observable<List<Course>> {
        TODO("Not yet implemented")
    }

}