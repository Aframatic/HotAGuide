package com.example.hotaguide.Category.Creatures.CreatureList.CreatureDescription.HOTACreatureDescription

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Creatures.CreatureList.CreatureListActivity
import com.example.hotaguide.R

class CreatureDescriptionAdapter(
    private val hotaList: List<HOTACreatureDescription>, var context: Context
) : RecyclerView.Adapter<CreatureDescriptionAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.activity_creature_description, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].name
        p0.description.text = hotaList[p1].specificity
        p0.attack.text = hotaList[p1].attack.toString()
        p0.defense.text = hotaList[p1].defense.toString()
        p0.ammo.text = hotaList[p1].ammo.toString()
        p0.damage.text = hotaList[p1].damage
        p0.health.text = hotaList[p1].health.toString()
        p0.speed.text = hotaList[p1].speed.toString()

        val imageId = context.resources.getIdentifier(
            hotaList[p1].image,
            "drawable",
            context.packageName
        )
        p0.image.setImageResource(imageId)

    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.creature_description_name)
        var image: ImageView = view.findViewById(R.id.creature_description_image)
        val description: TextView = view.findViewById(R.id.creature_description_desc)
        val attack: TextView = view.findViewById(R.id.creature_attack)
        val defense: TextView = view.findViewById(R.id.creature_defense)
        val ammo: TextView = view.findViewById(R.id.creature_ammo)
        val damage: TextView = view.findViewById(R.id.creature_damage)
        val health: TextView = view.findViewById(R.id.creature_health)
        val speed: TextView = view.findViewById(R.id.creature_speed)
    }
}