package com.noelon.timetracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.noelon.core_model.TaskModel
import com.noelon.timetracker.R
import com.noelon.timetracker.databinding.TaskItemLayoutBinding

class TaskAdapter() : ListAdapter<TaskModel, TaskAdapter.TaskViewHolder>(TaskDiffUtil()) {

    inner class TaskViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val colours = listOf(
            ContextCompat.getColor(binding.root.context, R.color.grey),
            ContextCompat.getColor(binding.root.context, R.color.orange),
            ContextCompat.getColor(binding.root.context, R.color.purpleish)
        )

        fun bind(taskModel: TaskModel) {
            with(binding) {
                tvTaskCheck.text = taskModel.title
                tvTaskCheck.isChecked = taskModel.isCompleted
                itemConstraintLayout.setBackgroundColor(colours.random())
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item_layout, parent, false)
        return TaskViewHolder(TaskItemLayoutBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TaskDiffUtil : DiffUtil.ItemCallback<TaskModel>() {
    override fun areItemsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
        return oldItem == newItem
    }

}