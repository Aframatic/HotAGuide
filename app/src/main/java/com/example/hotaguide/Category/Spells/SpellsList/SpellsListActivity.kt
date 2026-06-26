package com.example.hotaguide.Category.Spells.SpellsList

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList.SpellsListAdapter
import com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList.SpellsListDatabase
import com.example.hotaguide.R

class SpellsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val idCategory = intent.getIntExtra("category_id", 0)
        var nameCategory = intent.getStringExtra("category_name")

        when (idCategory) {
            11 -> {
                nameCategory = "Заклинания огня"
            }

            12 -> {
                nameCategory = "Заклинания земли"
            }

            13 -> {
                nameCategory = "Заклинания воздуха"
            }

            14 -> {
                nameCategory = "Заклинания воды"
            }

            15 -> {
                nameCategory = "Адаптивные заклинания"
            }
        }

        val title: TextView = findViewById(R.id.title)
        title.text = nameCategory

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = SpellsListAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = SpellsListDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = SpellsListAdapter(categoryList, this)
        recyclerView.setLayoutManager(GridLayoutManager(this, 3))
        recyclerView.adapter = categoryAdapter
    }
}