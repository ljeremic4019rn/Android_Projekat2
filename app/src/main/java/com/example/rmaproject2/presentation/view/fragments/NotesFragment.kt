package com.example.rmaproject2.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rmaproject2.R
import com.example.rmaproject2.databinding.FragmentCourseBinding
import com.example.rmaproject2.databinding.FragmentNotesBinding
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.recycler.adapter.CourseAdapter
import com.example.rmaproject2.presentation.view.recycler.adapter.NotesAdapter
import com.example.rmaproject2.presentation.view.states.CourseState
import com.example.rmaproject2.presentation.view.states.NoteState
import com.example.rmaproject2.presentation.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class NotesFragment : Fragment(R.layout.fragment_notes){


    private val noteViewModel: NoteContract.ViewModel by sharedViewModel<NotesViewModel>()
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NotesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        initRecycler()
        initListeners()
        initObservers()
    }


    private fun initRecycler() {
        binding.notesRV.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter()
        binding.notesRV.adapter = adapter
    }

    private fun initListeners() {

    }

    private fun initObservers() {

    }

    private fun renderState(state: NoteState) {
        when (state) {
            is NoteState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.notes)
            }
            is NoteState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is NoteState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show()
            }
            is NoteState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        binding.notesSearch.isVisible = !loading
        binding.notesRV.isVisible = !loading
        binding.loadingNotes.isVisible = loading
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}