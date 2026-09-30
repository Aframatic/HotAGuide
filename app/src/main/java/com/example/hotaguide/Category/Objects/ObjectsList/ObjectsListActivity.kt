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
import com.example.hotaguide.Category.Objects.ObjectsList.HOTAObjectsList.ObjectListAdapter
import com.example.hotaguide.Category.Objects.ObjectsList.HOTAObjectsList.ObjectsListDatabase
import com.example.hotaguide.R

class ObjectsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_objects)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.objects)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameObject = intent.getStringExtra("object_name")
        val imageObject = intent.getStringExtra("object_image")
        val imageGridObject = intent.getStringExtra("object_grid")
        val idObject = intent.getIntExtra("object_id", 0)


        val title: TextView = findViewById(R.id.title)
        title.text = "Объект"

        val objectImage: ImageView = findViewById(R.id.object_image)
        val objectImageGrid: ImageView = findViewById(R.id.grid_object)
        val objectName: TextView = findViewById(R.id.object_name)
        val objectButton: Button = findViewById(R.id.object_button)

        objectName.text = nameObject

        val collection_image = resources.getIdentifier(
            imageObject,
            "drawable",
            packageName
        )

        val collection_image_2 = resources.getIdentifier(
            imageGridObject,
            "drawable",
            packageName
        )

        objectImage.setImageResource(collection_image)
        objectImageGrid.setImageResource(collection_image_2)

        val recyclerView: RecyclerView = findViewById(R.id.objects_list)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        var categoryAdapter = ObjectListAdapter(emptyList(), this)
        recyclerView.adapter = categoryAdapter

        val database = ObjectsListDatabase(this)

        val categoryList = database.getObjects(idObject)
        categoryAdapter = ObjectListAdapter(categoryList, this)
        recyclerView.layoutManager = myLinearLayoutManager
        recyclerView.adapter = categoryAdapter

        objectButton.setOnClickListener {
            val intent = Intent(this, ObjectCleaningActivity::class.java)
            intent.putExtra("object_id", idObject)
            this.startActivity(intent)
        }
    }
}