package com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.ItemArtefact

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hotaguide.R


class ItemArtefactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jebus_artefact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Артефакт"

        val nameCollection = intent.getStringExtra("artefact_name")
        val nameDescription = intent.getStringExtra("artefact_description")
        val nameImage = intent.getStringExtra("artefact_image")

        val artefactImage: ImageView = findViewById(R.id.artefact_image)
        val artefactName: TextView = findViewById(R.id.artefact_name)
        val collectionDescription: TextView = findViewById(R.id.collection_description)

        artefactName.text = nameCollection
        collectionDescription.text = nameDescription

        val collection_image = resources.getIdentifier(
            nameImage,
            "drawable",
            packageName
        )

        artefactImage.setImageResource(collection_image)
    }
}