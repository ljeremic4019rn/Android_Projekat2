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
import com.example.rmaproject2.databinding.FragmentNotesBinding
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.recycler.adapter.NotesAdapter
import com.example.rmaproject2.presentation.view.states.NoteState
import com.example.rmaproject2.presentation.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import androidx.lifecycle.Observer

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
        init()
    }

    private fun init() {
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
        binding.switch1.setOnClickListener {
            if(binding.switch1.isChecked) {
                noteViewModel.getAllArchived()
            } else {
                noteViewModel.getAll()
            }
        }
    }

    private fun initObservers() {
        noteViewModel.noteState.observe(viewLifecycleOwner, Observer { noteState ->
            Timber.e(noteState.toString())
            renderState(noteState)
        })
        noteViewModel.getAll()
    }

    private fun renderState(state: NoteState) {
        when (state) {
            is NoteState.Success -> {
                adapter.submitList(state.notes)
            }
            is NoteState.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}