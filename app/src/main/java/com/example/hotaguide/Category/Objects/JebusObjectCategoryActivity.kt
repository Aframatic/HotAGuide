package com.example.hotaguide.Jebus.objects

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Jebus.objects.JebusObjectListCategoryAdapter.HOTAPattern
import com.example.hotaguide.R

class JebusObjectCategoryActivity : AppCompatActivity() {

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
        title.text = "Объекты"

        val itemList: RecyclerView = findViewById(R.id.pattern)
        val items = arrayListOf<HOTAPattern>()

        items.add(HOTAPattern(1, "Погост", "churchyard"))
        items.add(HOTAPattern(2, "Улик", "evidence"))
        items.add(HOTAPattern(3, "Зефа", "zefa"))
        items.add(HOTAPattern(4, "Консерватория ", "conservatory"))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = JebusObjectListCategoryAdapter(items, this)
    }
}