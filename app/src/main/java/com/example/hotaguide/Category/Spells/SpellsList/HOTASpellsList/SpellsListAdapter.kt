package com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.ItemArtefact.ItemArtefactActivity
import com.example.hotaguide.Category.Spells.SpellsList.SpellDescription.SpellDescriptionActivity
import com.example.hotaguide.Category.Spells.SpellsList.SpellsListActivity
import com.example.hotaguide.R

class SpellsListAdapter(
    private val hotaList: List<HOTASpellsList>, var context: Context
) : RecyclerView.Adapter<SpellsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_jebus_artefacts_list, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val imageId = context.resources.getIdentifier(
            hotaList[p1].image,
            "drawable",
            context.packageName
        )

        p0.spellImage.setImageResource(imageId)

        p0.bt.setOnClickListener {
            val intent = Intent(context, SpellDescriptionActivity::class.java)
            intent.putExtra("spell_name", hotaList[p1].name)
            intent.putExtra("spell_image", hotaList[p1].image)
            intent.putExtra("cost_with_skill", hotaList[p1].costWithSkill)
            intent.putExtra("cost_without_skill", hotaList[p1].costWithoutSkill)
            intent.putExtra("basic", hotaList[p1].basic)
            intent.putExtra("advanced", hotaList[p1].advanced)
            intent.putExtra("expert", hotaList[p1].expert)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_pattern)
        var spellImage: ImageView = view.findViewById(R.id.artefact_image)
    }
}