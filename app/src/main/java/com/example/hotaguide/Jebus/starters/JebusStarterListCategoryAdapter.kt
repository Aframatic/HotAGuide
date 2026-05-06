package com.example.hotaguide.Jebus.starters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Jebus.starters.castles.bulwark.JebusStarterHeroBulwarkCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.castle.JebusStarterHeroCastleCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.conflux.JebusStarterHeroConfluxCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.cove.JebusStarterHeroCoveCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.dungeon.JebusStarterHeroDungeonCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.factory.JebusStarterHeroFactoryCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.fortress.JebusStarterHeroFortressCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.inferno.JebusStarterHeroInfernoCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.necropolis.JebusStarterHeroNecropolisCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.rampart.JebusStarterHeroRampartCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.stronghold.JebusStarterHeroStrongholdCategoryActivity
import com.example.hotaguide.Jebus.starters.castles.tower.JebusStarterHeroTowerCategoryActivity
import com.example.hotaguide.R

class JebusStarterListCategoryAdapter(
    private val hotaList: List<HOTAPattern>, var context: Context
) : RecyclerView.Adapter<JebusStarterListCategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].name

        val imageId = context.resources.getIdentifier(
            hotaList[p1].image,
            "drawable",
            context.packageName
        )
        p0.leftImage.setImageResource(imageId)
        p0.rightImage.setImageResource(imageId)

        p0.bt.setOnClickListener {
            var intent = Intent()

            if (p0.name.text == "Замок") {
                intent = Intent(context, JebusStarterHeroCastleCategoryActivity::class.java)
            }
            if (p0.name.text == "Цитадель") {
                intent =  Intent(context, JebusStarterHeroStrongholdCategoryActivity::class.java)
            }
            if (p0.name.text == "Темница") {
                intent =  Intent(context, JebusStarterHeroDungeonCategoryActivity::class.java)
            }
            if (p0.name.text == "Оплот") {
                intent =  Intent(context, JebusStarterHeroRampartCategoryActivity::class.java)
            }
            if (p0.name.text == "Башня") {
                intent =  Intent(context, JebusStarterHeroTowerCategoryActivity::class.java)
            }
            if (p0.name.text == "Инферно") {
                intent =  Intent(context, JebusStarterHeroInfernoCategoryActivity::class.java)
            }
            if (p0.name.text == "Некрополис") {
                intent =  Intent(context, JebusStarterHeroNecropolisCategoryActivity::class.java)
            }
            if (p0.name.text == "Крепость") {
                intent =  Intent(context, JebusStarterHeroFortressCategoryActivity::class.java)
            }
            if (p0.name.text == "Сопряжение") {
                intent =  Intent(context, JebusStarterHeroConfluxCategoryActivity::class.java)
            }
            if (p0.name.text == "Причал") {
                intent =  Intent(context, JebusStarterHeroCoveCategoryActivity::class.java)
            }
            if (p0.name.text == "Фабрика") {
                intent =  Intent(context, JebusStarterHeroFactoryCategoryActivity::class.java)
            }
            if (p0.name.text == "Кронверк") {
                intent =  Intent(context, JebusStarterHeroBulwarkCategoryActivity::class.java)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_pattern)
        var leftImage: ImageView = view.findViewById(R.id.right_image)
        var rightImage: ImageView = view.findViewById(R.id.left_image)

        val name: TextView = view.findViewById(R.id.hota_list_pattern)
    }

    data class HOTAPattern(
        val id: Int,
        val name: String,
        val image: String
    )
}