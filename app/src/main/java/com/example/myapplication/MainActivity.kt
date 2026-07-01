package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var emptyStateLayout: View
    private lateinit var fabAddTask: FloatingActionButton

    private var tasks = mutableListOf<Task>()
    private val PREFS_NAME = "task_prefs"
    private val TASKS_KEY = "tasks_list"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewTasks)
        emptyStateLayout = findViewById(R.id.emptyStateLayout)
        fabAddTask = findViewById(R.id.fabAddTask)

        adapter = TaskAdapter(
            onTaskCheckedChange = { task, isChecked ->
                task.isCompleted = isChecked
                saveTasks()
            },
            onDeleteTask = { task ->
                tasks.remove(task)
                saveTasks()
                updateUI()
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fabAddTask.setOnClickListener {
            showAddTaskDialog()
        }

        loadTasks()
        updateUI()
    }

    private fun showAddTaskDialog() {
        val editText = EditText(this)
        editText.hint = "Task description"
        editText.setPadding(48, 48, 48, 48)

        AlertDialog.Builder(this)
            .setTitle("Add Task")
            .setView(editText)
            .setPositiveButton("Add") { dialog, _ ->
                val title = editText.text.toString()
                if (title.isNotBlank()) {
                    val newTask = Task(id = UUID.randomUUID().toString(), title = title)
                    tasks.add(newTask)
                    saveTasks()
                    updateUI()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    private fun saveTasks() {
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(tasks)
        editor.putString(TASKS_KEY, json)
        editor.apply()
    }

    private fun loadTasks() {
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString(TASKS_KEY, null)
        val type = object : TypeToken<MutableList<Task>>() {}.type

        if (json != null) {
            tasks = gson.fromJson(json, type)
        }
    }

    private fun updateUI() {
        adapter.submitList(tasks)
        if (tasks.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyStateLayout.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyStateLayout.visibility = View.GONE
        }
    }
}
