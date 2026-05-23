package com.example.hotaguide.Category.CastlesStarters.HeroesCastle.HOTAHeroesCastle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CastlesStarters.HeroesCastle.Hero.HeroActivity
import com.example.hotaguide.R

class HeroesCastleAdapter(
    private val hotaList: List<HOTAHeroesCastle>, var context: Context
) : RecyclerView.Adapter<HeroesCastleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].heroName

        val imageId = context.resources.getIdentifier(
            hotaList[p1].heroImage,
            "drawable",
            context.packageName
        )

        p0.leftImage.setImageResource(imageId)
        p0.rightImage.setImageResource(imageId)

        p0.bt.setOnClickListener {
            val intent = Intent(context, HeroActivity::class.java)
            intent.putExtra("hero_name", hotaList[p1].heroName)
            intent.putExtra("hero_image", hotaList[p1].heroImage)
            intent.putExtra("hero_skill_image_1", hotaList[p1].heroSkillImage1)
            intent.putExtra("hero_skill_image_2", hotaList[p1].heroSkillImage2)
            intent.putExtra("special_image", hotaList[p1].specialImage)
            intent.putExtra("creature_image_1", hotaList[p1].creatureImage1)
            intent.putExtra("creature_image_2", hotaList[p1].creatureImage2)
            intent.putExtra("creature_image_3", hotaList[p1].creatureImage3)
            intent.putExtra("attack_skill", hotaList[p1].attackSkill)
            intent.putExtra("defense_skill", hotaList[p1].defenseSkill)
            intent.putExtra("power_skill", hotaList[p1].powerSkill)
            intent.putExtra("knowledge_skill", hotaList[p1].knowledgeSkill)
            intent.putExtra("hero_skill_name_1", hotaList[p1].heroSkillName1)
            intent.putExtra("hero_skill_name_2", hotaList[p1].heroSkillName2)
            intent.putExtra("special_name", hotaList[p1].specialName)
            intent.putExtra("special_description", hotaList[p1].specialDescription)
            intent.putExtra("creature_name_1", hotaList[p1].creatureCount1)
            intent.putExtra("creature_name_2", hotaList[p1].creatureCount2)
            intent.putExtra("creature_name_3", hotaList[p1].creatureCount3)
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