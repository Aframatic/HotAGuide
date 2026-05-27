package com.example.hotaguide.Category.Creatures

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Creatures.HOTACreatures.CreaturesDatabase
import com.example.hotaguide.Category.Creatures.HOTACreatures.CreaturesAdapter
import com.example.hotaguide.R

class CreaturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameCategory = intent.getStringExtra("category_name")
        val idCategory = intent.getIntExtra("category_id", 0)

        val title: TextView = findViewById(R.id.title)
        title.text = nameCategory

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CreaturesAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CreaturesDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = CreaturesAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}