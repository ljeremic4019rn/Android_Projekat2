package com.example.rmaproject2.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rmaproject2.R
import com.example.rmaproject2.databinding.FragmentCourseBinding
import com.example.rmaproject2.presentation.contract.CourseContract
import com.example.rmaproject2.presentation.view.recycler.adapter.CourseAdapter
import com.example.rmaproject2.presentation.view.states.CourseState
import com.example.rmaproject2.presentation.viewModels.CourseViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import androidx.lifecycle.Observer
class CourseFragment: Fragment(R.layout.fragment_course) {

    private val courseViewModel: CourseContract.ViewModel by sharedViewModel<CourseViewModel>()
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
        binding.courseRv.layoutManager = LinearLayoutManager(context)
        adapter = CourseAdapter()
        binding.courseRv.adapter = adapter
    }

    private fun initListeners() {//todo filtriranje po profesoru/predmetu
//        binding.inputEt.doAfterTextChanged {
//            val filter = it.toString()
//            mainViewModel.getMoviesByName(filter)
//        }
    }

    private fun initObservers() {
        courseViewModel.courseState.observe(viewLifecycleOwner, Observer { courseState ->
            Timber.e(courseState.toString())
            renderState(courseState)
        })
        courseViewModel.getAllCourses()
        courseViewModel.fetchAllCourses()
    }

    private fun renderState(state: CourseState) {
        when (state) {
            is CourseState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.courses)
            }
            is CourseState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is CourseState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show()
            }
            is CourseState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        binding.inputEt.isVisible = !loading
        binding.courseRv.isVisible = !loading
        binding.loadingPb.isVisible = loading
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}