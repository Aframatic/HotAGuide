package com.example.hotaguide.Jebus.starters.castles.inferno.calh

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hotaguide.R

class JebusStarterHeroCalhActivity : AppCompatActivity() {
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
        title.text = "Калх"

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

        hero_image.setImageResource(R.drawable.hero_calh)
        hero_skill_image_1.setImageResource(R.drawable.basic_archery_large)
        hero_skill_image_2.setImageResource(R.drawable.basic_logistics_large)
        special_image.setImageResource(R.drawable.gog_portrait)
        creature_image_1.setImageResource(R.drawable.gog_portrait)
        creature_image_2.setImageResource(R.drawable.gog_portrait)
        creature_image_3.setImageResource(R.drawable.gog_portrait)

        attack_skill.text = "2"
        defense_skill.text = "2"
        power_skill.text = "1"
        knowledge_skill.text = "1"
        hero_skill_name_1.text = "Стрельба"
        hero_skill_name_2.text = "Разведка"
        special_name.text = "Специализация: Гоги"
        special_description.text =
            "Увеличивает скорость Гогов и Магогов на 1, а их атаку и защиту — на 20% за каждый уровень героя (с округлением вверх)."
        creature_name_1.text = "5-7"
        creature_name_2.text = "5-7"
        creature_name_3.text = "5-7"
    }
}