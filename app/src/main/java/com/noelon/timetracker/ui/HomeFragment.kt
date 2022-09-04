package com.noelon.timetracker.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.noelon.core_data.dummyConditions
import com.noelon.core_data.dummySort
import com.noelon.core_data.dummyTaskList
import com.noelon.core_data.dummyTime
import com.noelon.core_model.TaskModel
import com.noelon.timetracker.R
import com.noelon.timetracker.adapter.TaskAdapter
import com.noelon.timetracker.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: TaskViewModel by viewModels()
    private val taskAdapter = TaskAdapter()


    private lateinit var timeMenu: PopupMenu
    private lateinit var repeatMenu: PopupMenu
    private lateinit var sortMenu: PopupMenu
    private lateinit var startMenu: PopupMenu
    private lateinit var endMenu: PopupMenu

    private val contextWrapper: ContextThemeWrapper by lazy {
        ContextThemeWrapper(requireContext(), R.style.PopupMenu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        observeFlow()

        setClickListeners()

        addButtonClick()

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
                taskAdapter.submitList(it)
            }
        }
    }

    private fun setClickListeners() {
        with(binding) {

            tvTimePicker.setOnClickListener {
                timeMenu = PopupMenu(contextWrapper, it)
                dummyTime.forEach { time ->
                    timeMenu.menu.add(time)
                }

                timeMenu.show()
                timeMenu.setOnMenuItemClickListener(this@HomeFragment)
            }

            tvDoesntRepeat.setOnClickListener {
                repeatMenu = PopupMenu(contextWrapper, it)
                dummyConditions.forEach { time ->
                    repeatMenu.menu.add(time)
                }

                repeatMenu.show()
                repeatMenu.setOnMenuItemClickListener { item -> onRepeatItemClick(item) }
            }

            tvStartTime.setOnClickListener {
                startMenu = PopupMenu(contextWrapper, it)
                dummyTime.forEach { time ->
                    startMenu.menu.add(time)
                }

                startMenu.show()
                startMenu.setOnMenuItemClickListener { item -> onStartItemClick(item) }
            }

            tvEndTime.setOnClickListener {
                endMenu = PopupMenu(contextWrapper, it)
                dummyTime.forEach { time ->
                    endMenu.menu.add(time)
                }

                endMenu.show()
                endMenu.setOnMenuItemClickListener { item -> onEndItemClick(item) }
            }

            ivSortIcon.setOnClickListener {
                sortMenu = PopupMenu(contextWrapper, it)
                dummySort.forEach { time ->
                    sortMenu.menu.add(time)
                }

                sortMenu.show()
                sortMenu.setOnMenuItemClickListener { item -> onSortItemClick(item) }
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        binding.tvTimePicker.text = item?.title
        return true
    }

    private fun onRepeatItemClick(item: MenuItem): Boolean {
        binding.tvDoesntRepeat.text = item.title
        return true
    }

    private fun onStartItemClick(item: MenuItem): Boolean {
        binding.tvStartTime.text = item.title
        return true
    }

    private fun onEndItemClick(item: MenuItem): Boolean {
        binding.tvEndTime.text = item.title
        return true
    }

    private fun onSortItemClick(item: MenuItem): Boolean {
        return true
    }

    private fun addButtonClick() {
        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val newTask = binding.etTextDetails.text
            if (newTask.isNotEmpty()) {
                viewModel.saveTaskDetails(
                    TaskModel(
                        title = newTask.toString(),
                        description = "",
                        isCompleted = false
                    )
                )
                viewModel.getTaskDetails()
            } else {
                Toast.makeText(requireContext(), "Add a description", Toast.LENGTH_SHORT).show()
            }
            binding.etTextDetails.text.clear()
        }
    }


}