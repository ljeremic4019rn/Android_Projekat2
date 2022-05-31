package rs.raf.vezbe11.modules

import com.example.rmaproject2.data.repositories.CourseRepository
import com.example.rmaproject2.presentation.viewModels.CourseSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val movieModule = module {

    viewModel { CourseSharedViewModel(movieRepository = get()) }

//    single<CourseRepository> { MovieRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }
//
//    single { get<MovieDataBase>().getMovieDao() }
//
//    single<MovieService> { create(retrofit = get()) }

}

