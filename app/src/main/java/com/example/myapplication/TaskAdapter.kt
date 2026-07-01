package com.example.myapplication

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val onTaskCheckedChange: (Task, Boolean) -> Unit,
    private val onDeleteTask: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val tasks = mutableListOf<Task>()

    fun submitList(newTasks: List<Task>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkboxTask: CheckBox = itemView.findViewById(R.id.checkboxTask)
        private val textViewTaskTitle: TextView = itemView.findViewById(R.id.textViewTaskTitle)
        private val buttonDelete: ImageButton = itemView.findViewById(R.id.buttonDelete)

        fun bind(task: Task) {
            textViewTaskTitle.text = task.title

            // Remove listener before setting checked state to avoid unwanted triggers
            checkboxTask.setOnCheckedChangeListener(null)
            checkboxTask.isChecked = task.isCompleted

            updateStrikeThrough(task.isCompleted)

            checkboxTask.setOnCheckedChangeListener { _, isChecked ->
                updateStrikeThrough(isChecked)
                onTaskCheckedChange(task, isChecked)
            }

            buttonDelete.setOnClickListener {
                onDeleteTask(task)
            }
        }

        private fun updateStrikeThrough(isCompleted: Boolean) {
            if (isCompleted) {
                textViewTaskTitle.paintFlags = textViewTaskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                textViewTaskTitle.paintFlags = textViewTaskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }
}
