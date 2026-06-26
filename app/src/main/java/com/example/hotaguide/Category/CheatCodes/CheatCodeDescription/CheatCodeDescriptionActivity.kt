package com.example.hotaguide.Category.CheatCodes.CheatCodeDescription

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hotaguide.R

class CheatCodeDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cheat_code)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Заклинание"

        val nameCheat = intent.getStringExtra("name")
        val textCheat = intent.getStringExtra("text")

        val name: TextView = findViewById(R.id.cheat_name)
        val text: TextView = findViewById(R.id.cheat_description)

        name.text = nameCheat
        text.text = textCheat
    }
}