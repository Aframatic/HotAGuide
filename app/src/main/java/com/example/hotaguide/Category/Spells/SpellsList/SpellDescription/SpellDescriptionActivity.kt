package com.example.hotaguide.Category.Spells.SpellsList.SpellDescription

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.HOTAArtefacts.ArtefactsAdapter
import com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.HOTAArtefacts.ArtefactsDatabase
import com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList.SpellsListAdapter
import com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList.SpellsListDatabase
import com.example.hotaguide.R

class SpellDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jebus_spell)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title: TextView = findViewById(R.id.title)
        title.text = "Заклинание"

        val spellName = intent.getStringExtra("spell_name")
        val spellImage = intent.getStringExtra("spell_image")
        val spellCostWithSkill = intent.getIntExtra("cost_with_skill", 0)
        val spellCostWithoutSkill = intent.getIntExtra("cost_without_skill", 0)
        val spellBasic = intent.getStringExtra("basic")
        val spellAdvanced = intent.getStringExtra("advanced")
        val spellExpert = intent.getStringExtra("expert")

        val spell_image: ImageView = findViewById(R.id.spell_image)
        val spell_name: TextView = findViewById(R.id.spell_name)
        val cost_with_skill: TextView = findViewById(R.id.cost_with_skill)
        val cost_without_skill: TextView = findViewById(R.id.cost_without_skill)
        val basic_magic: TextView = findViewById(R.id.basic_magic)
        val advanced_magic: TextView = findViewById(R.id.advanced_magic)
        val expert_magic: TextView = findViewById(R.id.expert_magic)

        spell_name.text = spellName
        basic_magic.text = spellBasic
        advanced_magic.text = spellAdvanced
        expert_magic.text = spellExpert
        cost_with_skill.text = spellCostWithSkill.toString()
        cost_without_skill.text = spellCostWithoutSkill.toString()

        val spell_image_res = resources.getIdentifier(
            spellImage,
            "drawable",
            packageName
        )

        spell_image.setImageResource(spell_image_res)
    }
}