package com.example.hotaguide

import android.content.ClipData
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.HOTAPattern.HOTAPatternDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var patternRecyclerView: RecyclerView
    private lateinit var patternAdapter: ListTitleAdapter
    private lateinit var database: HOTAPatternDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        patternRecyclerView = findViewById(R.id.pattern)
        patternAdapter = ListTitleAdapter(emptyList(), this)
        patternRecyclerView.adapter = patternAdapter

        database = HOTAPatternDatabase(this)

        val patternList = database.get()
        patternAdapter = ListTitleAdapter(patternList, this)
        patternRecyclerView.layoutManager = LinearLayoutManager(this)
        patternRecyclerView.adapter = patternAdapter
    }
}