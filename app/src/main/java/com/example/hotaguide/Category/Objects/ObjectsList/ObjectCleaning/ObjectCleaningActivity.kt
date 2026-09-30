package com.example.hotaguide.Jebus.objects

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Objects.HOTAObjects.ObjectAdapter
import com.example.hotaguide.Category.Objects.HOTAObjects.ObjectsCleaningDatabase
import com.example.hotaguide.Category.Objects.HOTAObjects.ObjectsDatabase
import com.example.hotaguide.Category.Objects.ObjectsList.HOTAObjectsList.ObjectListAdapter
import com.example.hotaguide.Category.Objects.ObjectsList.HOTAObjectsList.ObjectsListDatabase
import com.example.hotaguide.Category.Objects.ObjectsList.ObjectCleaning.HOTAObjectsCleaning.ObjectCleaningAdapter
import com.example.hotaguide.R

class ObjectCleaningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Персонаж для взятия раннего объекта"

        val idObject = intent.getIntExtra("object_id", 0)

        val recyclerView: RecyclerView = findViewById(R.id.pattern)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        var categoryAdapter = ObjectCleaningAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = ObjectsCleaningDatabase(this)

        val categoryList = database.getObjects(idObject)
        categoryAdapter = ObjectCleaningAdapter(categoryList, this)
        recyclerView.layoutManager = myLinearLayoutManager
        recyclerView.adapter = categoryAdapter
    }
}