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
            .doOnNext {
                Timber.e("Upis u bazu")
                val entities = it.map {
                    CourseEntity(
                        it.id,
                        it.subject,
                        it.type,
                        it.professor,
                        it.group,
                        it.day,
                        it.time,
                        it.classroom

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
            .map {
                it.map {
                    Course(it.id, it.subject, it.type, it.professor, it.group, it.day, it.time, it.classroom)
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