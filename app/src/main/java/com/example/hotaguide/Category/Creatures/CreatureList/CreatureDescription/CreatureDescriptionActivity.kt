package com.example.hotaguide.Category.Creatures.CreatureList.CreatureDescription

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Creatures.CreatureList.CreatureDescription.HOTACreatureDescription.CreatureDescriptionAdapter
import com.example.hotaguide.Category.Creatures.CreatureList.CreatureDescription.HOTACreatureDescription.CreatureDescriptionDatabase
import com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList.CreatureListAdapter
import com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList.CreatureListDatabase
import com.example.hotaguide.R

class CreatureDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val idCategory = intent.getIntExtra("creature_id", 0)

        val title: TextView = findViewById(R.id.title)
        title.text = "Существа"

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CreatureDescriptionAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CreatureDescriptionDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = CreatureDescriptionAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}