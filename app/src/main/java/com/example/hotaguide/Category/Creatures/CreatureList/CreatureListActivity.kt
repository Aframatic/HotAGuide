package com.example.hotaguide.Category.Creatures.CreatureList

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList.CreatureListAdapter
import com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList.CreatureListDatabase
import com.example.hotaguide.Category.Creatures.HOTACreatures.CreaturesDatabase
import com.example.hotaguide.Category.Creatures.HOTACreatures.CreaturesAdapter
import com.example.hotaguide.R

class CreatureListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameCategory = intent.getStringExtra("creature_name")
        val idCategory = intent.getIntExtra("creature_id", 0)

        val title: TextView = findViewById(R.id.title)
        title.text = nameCategory

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CreatureListAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CreatureListDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = CreatureListAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}