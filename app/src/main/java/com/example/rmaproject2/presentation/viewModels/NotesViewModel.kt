package com.example.rmaproject2.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rmaproject2.data.models.note.Note
import com.example.rmaproject2.data.models.note.NoteEntity
import com.example.rmaproject2.data.repositories.NotesRepository
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.states.NoteState
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class NotesViewModel (private val notesRepository: NotesRepository) : ViewModel(), NoteContract.ViewModel  {
    private val subscriptions = CompositeDisposable()
    override val noteState: MutableLiveData<NoteState> = MutableLiveData()


    override fun getAll(){
        TODO("Not yet implemented")
    }

    override fun getAllByName(name: String){
        TODO("Not yet implemented")
    }

    override fun getAllByContent(name: String){
        TODO("Not yet implemented")
    }

    override fun getAllArchived() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

}