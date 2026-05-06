package com.example.hotaguide.Jebus.starters

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Jebus.starters.JebusStarterListCategoryAdapter.HOTAPattern
import com.example.hotaguide.R

class JebusStarterCategoryActivity : AppCompatActivity() {

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
        title.text = "Замок стартера"

        val itemList: RecyclerView = findViewById(R.id.pattern)
        val items = arrayListOf<HOTAPattern>()

        items.add(HOTAPattern(1, "Замок", "castle"))
        items.add(HOTAPattern(2, "Цитадель", "stronghold"))
        items.add(HOTAPattern(3, "Темница", "dungeon"))
        items.add(HOTAPattern(4, "Оплот", "rampart"))
        items.add(HOTAPattern(5, "Башня", "tower"))
        items.add(HOTAPattern(6, "Инферно", "inferno"))
        items.add(HOTAPattern(7, "Некрополис", "necropolis"))
        items.add(HOTAPattern(8, "Крепость", "fortress"))
        items.add(HOTAPattern(9, "Сопряжение", "conflux"))
        items.add(HOTAPattern(10, "Причал", "cove"))
        items.add(HOTAPattern(11, "Фабрика", "factory"))
        items.add(HOTAPattern(12, "Кронверк", "bulwark"))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = JebusStarterListCategoryAdapter(items, this)
    }
}