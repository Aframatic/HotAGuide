package com.example.hotaguide.Jebus.objects

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Objects.HOTAObjects.ObjectAdapter
import com.example.hotaguide.Category.Objects.HOTAObjects.ObjectsDatabase
import com.example.hotaguide.R

class ObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Объекты"

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = ObjectAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = ObjectsDatabase(this)

        println(2222222222222)
        println(2222222222222222)

        val categoryList = database.getObjects()
        categoryAdapter = ObjectAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}