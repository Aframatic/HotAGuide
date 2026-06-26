package com.example.hotaguide.Category.CheatCodes

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CheatCodes.HOTACheatCodes.CheatCodesAdapter
import com.example.hotaguide.Category.CheatCodes.HOTACheatCodes.CheatCodesDatabase
import com.example.hotaguide.Category.Spells.HOTASpells.SpellsDatabase
import com.example.hotaguide.Category.Spells.HOTASpells.SpellsAdapter
import com.example.hotaguide.R

class CheatCodesActivity : AppCompatActivity() {
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

        val title: TextView = findViewById(R.id.title)
        title.text = nameCategory

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CheatCodesAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CheatCodesDatabase(this)

        val categoryList = database.get()
        categoryAdapter = CheatCodesAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}