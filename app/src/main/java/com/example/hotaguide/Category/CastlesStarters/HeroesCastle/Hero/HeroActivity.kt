package com.example.hotaguide.Category.CastlesStarters.HeroesCastle.Hero

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hotaguide.R

class HeroActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starters_heroes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val heroName = intent.getStringExtra("hero_name")
        val heroImage = intent.getStringExtra("hero_image")
        val heroSkillImage1 = intent.getStringExtra("hero_skill_image_1")
        val heroSkillImage2 = intent.getStringExtra("hero_skill_image_2")
        val specialImage = intent.getStringExtra("special_image")
        val creatureImage1 = intent.getStringExtra("creature_image_1")
        val creatureImage2 = intent.getStringExtra("creature_image_2")
        val creatureImage3 = intent.getStringExtra("creature_image_3")
        val attackSkill = intent.getIntExtra("attack_skill", 0)
        val defenseSkill = intent.getIntExtra("defense_skill", 0)
        val powerSkill = intent.getIntExtra("power_skill", 0)
        val knowledgeSkill = intent.getIntExtra("knowledge_skill", 0)
        val heroSkillName1 = intent.getStringExtra("hero_skill_name_1")
        val heroSkillName2 = intent.getStringExtra("hero_skill_name_2")
        val specialName = intent.getStringExtra("special_name")
        val specialDescription = intent.getStringExtra("special_description")
        val creatureCount1 = intent.getStringExtra("creature_name_1")
        val creatureCount2 = intent.getStringExtra("creature_name_2")
        val creatureCount3 = intent.getStringExtra("creature_name_3")

        val title: TextView = findViewById(R.id.title)
        title.text = heroName

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
        val hero_skill_name_1: TextView = findViewById(R.id.hero_skill_name1)
        val hero_skill_name_2: TextView = findViewById(R.id.hero_skill_name2)
        val special_name: TextView = findViewById(R.id.special_name)
        val special_description: TextView = findViewById(R.id.special_description)
        val creature_name_1: TextView = findViewById(R.id.creature_name1)
        val creature_name_2: TextView = findViewById(R.id.creature_name2)
        val creature_name_3: TextView = findViewById(R.id.creature_name3)

        val hero_image_res = resources.getIdentifier(
            heroImage,
            "drawable",
            packageName
        )

        val hero_skill_image_1_res = resources.getIdentifier(
            heroSkillImage1,
            "drawable",
            packageName
        )

        val hero_skill_image_2_res = resources.getIdentifier(
            heroSkillImage2,
            "drawable",
            packageName
        )

        val special_image_res = resources.getIdentifier(
            specialImage,
            "drawable",
            packageName
        )

        val creature_image_1_res = resources.getIdentifier(
            creatureImage1,
            "drawable",
            packageName
        )

        val creature_image_2_res = resources.getIdentifier(
            creatureImage2,
            "drawable",
            packageName
        )

        val creature_image_3_res = resources.getIdentifier(
            creatureImage3,
            "drawable",
            packageName
        )

        hero_image.setImageResource(hero_image_res)
        hero_skill_image_1.setImageResource(hero_skill_image_1_res)
        hero_skill_image_2.setImageResource(hero_skill_image_2_res)
        special_image.setImageResource(special_image_res)
        creature_image_1.setImageResource(creature_image_1_res)
        creature_image_2.setImageResource(creature_image_2_res)
        creature_image_3.setImageResource(creature_image_3_res)

        attack_skill.text = attackSkill.toString()
        defense_skill.text = defenseSkill.toString()
        power_skill.text = powerSkill.toString()
        knowledge_skill.text = knowledgeSkill.toString()
        hero_skill_name_1.text = heroSkillName1
        hero_skill_name_2.text = heroSkillName2
        special_name.text = "Специализация: $specialName"
        special_description.text = specialDescription
        creature_name_1.text = creatureCount1
        creature_name_2.text = creatureCount2
        creature_name_3.text = creatureCount3
    }
}