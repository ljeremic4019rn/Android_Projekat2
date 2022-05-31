package com.example.rmaproject2.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rmaproject2.R
import com.example.rmaproject2.databinding.FragmentCourseBinding
import com.example.rmaproject2.presentation.contract.CourseContract
import com.example.rmaproject2.presentation.view.recycler.adapter.CourseAdapter
import com.example.rmaproject2.presentation.viewModels.CourseSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StatisticsFragment: Fragment(R.layout.fragment_statistics) {

    private val ssViewModel: CourseContract.ViewModel by sharedViewModel<CourseSharedViewModel>()

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CourseAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
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
        binding.scheduleRV.layoutManager = LinearLayoutManager(context)
        adapter = CourseAdapter()
        binding.scheduleRV.adapter = adapter
    }

    private fun initListeners() {
        binding.inputEt.doAfterTextChanged {
            val filter = it.toString()
//            ScheduleSharedViewModel.getMoviesByName(filter) todo
        }
    }

    private fun initObservers() {
        ssViewModel.fetchAllCourses()
    }

}