package com.example.hotaguide.Jebus.starters.castles.bulwark

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Jebus.starters.castles.bulwark.JebusStarterHeroBulwarkListCategoryAdapter.HOTAPattern
import com.example.hotaguide.R

class JebusStarterHeroBulwarkCategoryActivity : AppCompatActivity() {

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
        title.text = "Стартеры"

        val itemList: RecyclerView = findViewById(R.id.pattern)
        val items = arrayListOf<HOTAPattern>()

        items.add(HOTAPattern(1, "Кунр", "hero_kynr"))
        items.add(HOTAPattern(2, "Ейктхурн", "hero_eikthurn"))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = JebusStarterHeroBulwarkListCategoryAdapter(items, this)
    }
}