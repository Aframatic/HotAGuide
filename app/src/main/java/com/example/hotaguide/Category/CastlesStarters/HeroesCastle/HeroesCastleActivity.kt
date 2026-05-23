package com.example.hotaguide.Category.CastlesStarters.HeroesCastle

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CastlesStarters.HeroesCastle.HOTAHeroesCastle.HeroesCastleDatabase
import com.example.hotaguide.Category.CastlesStarters.HeroesCastle.HOTAHeroesCastle.HeroesCastleAdapter
import com.example.hotaguide.R

class HeroesCastleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val starterName = intent.getStringExtra("starter_name")
        val starterId = intent.getIntExtra("starter_id", 0)

        val title: TextView = findViewById(R.id.title)
        title.text = starterName

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = HeroesCastleAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = HeroesCastleDatabase(this)

        val categoryList = database.get(starterId)
        categoryAdapter = HeroesCastleAdapter(categoryList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryAdapter
    }
}