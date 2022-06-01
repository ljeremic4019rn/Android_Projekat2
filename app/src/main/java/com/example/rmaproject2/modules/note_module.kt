import com.example.rmaproject2.data.datasource.local.CourseDataBase
import com.example.rmaproject2.data.datasource.local.NoteDataBase
import com.example.rmaproject2.data.datasource.remote.CourseService
import com.example.rmaproject2.data.repositories.CourseRepository
import com.example.rmaproject2.data.repositories.CourseRepositoryImpl
import com.example.rmaproject2.data.repositories.NotesRepository
import com.example.rmaproject2.data.repositories.NotesRepositoryImpl
import com.example.rmaproject2.presentation.viewModels.CourseViewModel
import com.example.rmaproject2.presentation.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val noteModule = module {

    viewModel { NotesViewModel(notesRepository = get()) }

    single<NotesRepository> { NotesRepositoryImpl(localDataSource = get()) }

    single { get<NoteDataBase>().getNoteDao() }

//    single<CourseService> { create(retrofit = get()) }

}