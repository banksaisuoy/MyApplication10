package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "My Tasks"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummyTasks = listOf(
            Task("Design UI", "Create a premium visual style for the app", true),
            Task("Implement Data Model", "Create Kotlin data classes"),
            Task("Setup RecyclerView", "Bind data to layout using Adapter"),
            Task("Review Code", "Ensure code is modular and clean"),
            Task("Write Tests", "Add unit and integration tests")
        )

        val adapter = TaskAdapter(dummyTasks)
        recyclerView.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.fabAddTask)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Add new task clicked", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()
        }
    }
}
