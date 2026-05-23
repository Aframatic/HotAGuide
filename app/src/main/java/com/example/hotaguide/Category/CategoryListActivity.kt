package com.example.hotaguide.Category

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.HOTACategory.CategoryDatabase
import com.example.hotaguide.Category.HOTACategory.CategoryListAdapter
import com.example.hotaguide.R

class CategoryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val namePattern = intent.getStringExtra("pattern_name")

        val title: TextView = findViewById(R.id.title)
        title.text = namePattern

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CategoryListAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CategoryDatabase(this)

        val categoryList = database.getCategory()
        categoryAdapter = CategoryListAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}