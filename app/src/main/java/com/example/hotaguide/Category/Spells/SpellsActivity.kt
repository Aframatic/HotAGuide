package com.example.hotaguide.Category.Spells

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CastlesStarters.HOTACastlesStarters.CastleStarterListAdapter
import com.example.hotaguide.Category.CastlesStarters.HOTACastlesStarters.CastleStartersDatabase
import com.example.hotaguide.Category.Spells.HOTASpells.SpellsDatabase
import com.example.hotaguide.Category.Spells.HOTASpells.SpellsListAdapter
import com.example.hotaguide.R

class SpellsActivity : AppCompatActivity() {
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
        var categoryAdapter = SpellsListAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = SpellsDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = SpellsListAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}