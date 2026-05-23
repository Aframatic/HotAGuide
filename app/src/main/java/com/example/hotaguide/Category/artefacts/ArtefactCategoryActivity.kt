package com.example.hotaguide.Category.artefacts

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.artefacts.HOTAArtefact.ArtefactsDatabase
import com.example.hotaguide.Category.artefacts.HOTAArtefact.ArtefactListCategoryAdapter
import com.example.hotaguide.R

class ArtefactCategoryActivity : AppCompatActivity() {

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
        var categoryAdapter = ArtefactListCategoryAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = ArtefactsDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = ArtefactListCategoryAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}