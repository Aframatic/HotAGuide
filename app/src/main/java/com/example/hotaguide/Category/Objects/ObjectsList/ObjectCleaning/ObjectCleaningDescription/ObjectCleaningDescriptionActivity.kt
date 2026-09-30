package com.example.hotaguide.Jebus.objects

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.hotaguide.R


class ObjectCleaningDescriptionActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_object_cleaning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.objects)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameHero = intent.getStringExtra("name_hero")
        val startingArmyImage = intent.getStringExtra("starting_army_image")
        val grid = intent.getStringExtra("grid")
        val description = intent.getStringExtra("description")

        val title: TextView = findViewById(R.id.title)
        title.text = nameHero

        val objectImage: ImageView = findViewById(R.id.starting_army_image)
        val objectImageGrid: ImageView = findViewById(R.id.grid_object)
        val objectDescription: TextView = findViewById(R.id.object_description_cleaning)

        val collectionImage = resources.getIdentifier(
            startingArmyImage,
            "drawable",
            packageName
        )

        val collectionImage2 = resources.getIdentifier(
            grid,
            "drawable",
            packageName
        )

        objectImage.setImageResource(collectionImage)
        Glide.with(this)
            .load(collectionImage2)
            .into(objectImageGrid);

        objectDescription.text = description
    }
}