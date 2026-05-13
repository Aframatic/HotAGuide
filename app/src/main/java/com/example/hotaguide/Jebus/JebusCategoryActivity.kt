package com.example.hotaguide.Jebus

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.HOTAPattern.HOTAPattern
import com.example.hotaguide.R

class JebusCategoryActivity : AppCompatActivity() {

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
        title.text = "Jebus Cross"

        val itemList: RecyclerView = findViewById(R.id.pattern)
        val items = arrayListOf<HOTAPattern>()

        items.add(HOTAPattern(1, "Объекты"))
        items.add(HOTAPattern(2, "Стартеры"))
        items.add(HOTAPattern(3, "Артефакты"))
        items.add(HOTAPattern(4, "Существа"))
        items.add(HOTAPattern(5, "Заклинания"))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = JebusListCategoryAdapter(items, this)
    }
}