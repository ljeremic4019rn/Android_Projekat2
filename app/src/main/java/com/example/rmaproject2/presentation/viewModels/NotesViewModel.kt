package com.example.rmaproject2.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rmaproject2.data.models.note.NoteEntity
import com.example.rmaproject2.data.repositories.NotesRepository
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.states.CourseState
import com.example.rmaproject2.presentation.view.states.NoteState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class NotesViewModel (private val notesRepository: NotesRepository) : ViewModel(), NoteContract.ViewModel  {
    private val subscriptions = CompositeDisposable()
    override val noteState: MutableLiveData<NoteState> = MutableLiveData()


    override fun getAll(){
        val subscription = notesRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    noteState.value = NoteState.Success(it)
                },
                {
                    noteState.value = NoteState.Error("Error happened while fetching data from db")
                    Timber.e(it)                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllByTitle(title: String){
        val subscription = notesRepository
            .getAllByTitle(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    noteState.value = NoteState.Success(it)
                },
                {
                    noteState.value = NoteState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)    }

    override fun getAllByContent(content: String){
        val subscription = notesRepository
            .getAllByContent(content)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    noteState.value = NoteState.Success(it)
                },
                {
                    noteState.value = NoteState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllArchived() {
        val subscription = notesRepository
            .getAllArchived()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    noteState.value = NoteState.Success(it)
                },
                {
                    noteState.value = NoteState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteById(id: Long) {
        val subscription = notesRepository
            .deleteById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun insert(noteEntity: NoteEntity) {
        val subscription = notesRepository
            .insert(noteEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun updateNote(noteEntity: NoteEntity) {
        val subscription = notesRepository
            .updateNote(noteEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("UPDATED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

}