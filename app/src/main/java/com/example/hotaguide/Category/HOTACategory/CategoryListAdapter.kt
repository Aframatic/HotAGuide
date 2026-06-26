package com.example.hotaguide.Category.HOTACategory

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CastlesStarters.CastleStarterActivity
import com.example.hotaguide.Category.Artefacts.ArtefactCategoryActivity
import com.example.hotaguide.Category.CheatCodes.CheatCodesActivity
import com.example.hotaguide.Category.Creatures.CreaturesActivity
import com.example.hotaguide.Category.Spells.SpellsActivity
import com.example.hotaguide.R

class CategoryListAdapter(
    private val hotaList: List<HOTACategory>, var context: Context
) : RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return MyViewHolder(view)
    }

    @SuppressLint("IntentWithNullActionLaunch")
    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].name

        p0.bt.setOnClickListener {
            var intent = Intent()

            if (hotaList[p1].name == "Стартеры")
                intent = Intent(context, CastleStarterActivity::class.java)

            if (hotaList[p1].name == "Артефакты")
                intent = Intent(context, ArtefactCategoryActivity::class.java)

            if (hotaList[p1].name == "Существа")
                intent = Intent(context, CreaturesActivity::class.java)

            if (hotaList[p1].name == "Заклинания")
                intent = Intent(context, SpellsActivity::class.java)

            if (hotaList[p1].name == "Чит коды")
                intent = Intent(context, CheatCodesActivity::class.java)

            intent.putExtra("category_name", hotaList[p1].name)
            intent.putExtra("category_id", hotaList[p1].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_pattern)

        val name: TextView = view.findViewById(R.id.hota_list_pattern)
    }
}
