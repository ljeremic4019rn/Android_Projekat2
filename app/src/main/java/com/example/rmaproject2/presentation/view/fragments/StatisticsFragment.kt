package com.example.rmaproject2.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rmaproject2.R
import com.example.rmaproject2.databinding.FragmentNotesBinding
import com.example.rmaproject2.databinding.FragmentStatisticsBinding
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.view.recycler.adapter.NotesAdapter
import com.example.rmaproject2.presentation.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class StatisticsFragment: Fragment(R.layout.fragment_statistics) {

    private val noteViewModel: NoteContract.ViewModel by sharedViewModel<NotesViewModel>()
    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {

    }

}