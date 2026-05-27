package com.example.hotaguide.Category.Artefacts.ArtefactList.Collection

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.HOTACollection.CollectionAdapter
import com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.HOTACollection.CollectionDatabase
import com.example.hotaguide.R


class CollectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val idCategory = intent.getIntExtra("id_list", 0)
        val nameCategory = intent.getStringExtra("name_list")

        val title: TextView = findViewById(R.id.title)
        title.text = nameCategory

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        var categoryAdapter = CollectionAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = CollectionDatabase(this)

        val categoryList = database.get(idCategory)
        categoryAdapter = CollectionAdapter(categoryList, this)
        recyclerView.setLayoutManager(GridLayoutManager(this, 3))
        recyclerView.adapter = categoryAdapter
    }

}