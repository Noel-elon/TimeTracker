package com.noelon.timetracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.noelon.core_data.dummyTaskList
import com.noelon.timetracker.adapter.TaskAdapter
import com.noelon.timetracker.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: TaskViewModel by viewModels()
    private val taskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        observeFlow()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.taskRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = taskAdapter
        }
    }

    private fun observeFlow() {
        lifecycleScope.launch {
            viewModel.taskDetails.collect {
                taskAdapter.submitList(dummyTaskList)
                Log.d("Data::", it.toString())
            }
        }
    }

}