package com.example.hotaguide.Jebus.artefacts

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Jebus.artefacts.JebusArtefactListCategoryAdapter.HOTAPattern
import com.example.hotaguide.R

class JebusArtefactCategoryActivity : AppCompatActivity() {

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
        title.text = "Артефакты"

        val itemList: RecyclerView = findViewById(R.id.pattern)
        val items = arrayListOf<HOTAPattern>()

        items.add(HOTAPattern(1, "Сборник", "artifact_angelic_alliance"))
        items.add(HOTAPattern(2, "Шлем", "artifact_helm_of_heavenly_enlightenment"))
        items.add(HOTAPattern(3, "Ожерелье", "artifact_celestial_necklace_of_bliss"))
        items.add(HOTAPattern(4, "Оружие ", "artifact_sword_of_judgement"))
        items.add(HOTAPattern(5, "Щит ", "artifact_lions_shield_of_courage"))
        items.add(HOTAPattern(6, "Доспех ", "artifact_armor_of_wonder"))
        items.add(HOTAPattern(7, "Плащ ", "artifact_angel_wings"))
        items.add(HOTAPattern(8, "Ноги ", "artifact_sandals_of_the_saint"))
        items.add(HOTAPattern(9, "Кольцо ", "artifact_ring_of_vitality"))
        items.add(HOTAPattern(10, "Разное ", "artifact_tome_of_earth_magic"))







        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = JebusArtefactListCategoryAdapter(items, this)
    }
}