package com.example.hotaguide.Jebus.starters.castles.tower.solmyr

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hotaguide.R

class JebusStarterHeroSolmyrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starters_heroes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Солмир"

        val hero_image: ImageView = findViewById(R.id.hero_image)
        val hero_skill_image_1: ImageView = findViewById(R.id.hero_skill_image1)
        val hero_skill_image_2: ImageView = findViewById(R.id.hero_skill_image2)
        val special_image: ImageView = findViewById(R.id.special_image)
        val creature_image_1: ImageView = findViewById(R.id.creature_image1)
        val creature_image_2: ImageView = findViewById(R.id.creature_image2)
        val creature_image_3: ImageView = findViewById(R.id.creature_image3)

        val attack_skill: TextView = findViewById(R.id.attack_skill)
        val defense_skill: TextView = findViewById(R.id.defense_skill)
        val power_skill: TextView = findViewById(R.id.power_skill)
        val knowledge_skill: TextView = findViewById(R.id.knowledge_skill)
        val hero_skill_category_1: TextView = findViewById(R.id.hero_skill_category1)
        val hero_skill_name_1: TextView = findViewById(R.id.hero_skill_name1)
        val hero_skill_category_2: TextView = findViewById(R.id.hero_skill_category2)
        val hero_skill_name_2: TextView = findViewById(R.id.hero_skill_name2)
        val special_name: TextView = findViewById(R.id.special_name)
        val special_description: TextView = findViewById(R.id.special_description)
        val creature_name_1: TextView = findViewById(R.id.creature_name1)
        val creature_name_2: TextView = findViewById(R.id.creature_name2)
        val creature_name_3: TextView = findViewById(R.id.creature_name3)

        hero_image.setImageResource(R.drawable.hero_solmyr)
        hero_skill_image_1.setImageResource(R.drawable.basic_wisdom)
        hero_skill_image_2.setImageResource(R.drawable.basic_sorcery_large)
        special_image.setImageResource(R.drawable.chain_lightning)
        creature_image_1.setImageResource(R.drawable.gremlin_portrait)
        creature_image_2.setImageResource(R.drawable.stone_gargoyle_portrait)
        creature_image_3.setImageResource(R.drawable.stone_golem_portrait)

        attack_skill.text = "0"
        defense_skill.text = "2"
        power_skill.text = "2"
        knowledge_skill.text = "3"
        hero_skill_name_1.text = "Мудрость"
        hero_skill_name_2.text = "Волшебство"
        special_name.text = "Специализация: Цепная Молния"
        special_description.text =
            "Увеличивает урон заклинания Цепная Молния на 5% за каждые n уровней героя, где n - уровень существа цели."
        creature_name_1.text = "30-40"
        creature_name_2.text = "5-7"
        creature_name_3.text = "4-5"
    }
}