package com.example.hotaguide.Category.Objects.ObjectsList.ObjectCleaning.HOTAObjectsCleaning

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
import com.example.hotaguide.Jebus.objects.ObjectCleaningDescriptionActivity
import com.example.hotaguide.R

class ObjectCleaningAdapter(
    private val hotaList: List<HOTAObjectCleaning>, var context: Context
) : RecyclerView.Adapter<ObjectCleaningAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.activity_object_cleaning_list, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].nameHero

        val imageId = context.resources.getIdentifier(
            hotaList[p1].imageHero,
            "drawable",
            context.packageName
        )
        p0.image.setImageResource(imageId)

        p0.bt.setOnClickListener {
            val intent = Intent(context, ObjectCleaningDescriptionActivity::class.java)
            intent.putExtra("name_hero", hotaList[p1].nameHero)
            intent.putExtra("starting_army_image", hotaList[p1].startingArmyImage)
            intent.putExtra("grid", hotaList[p1].grid)
            intent.putExtra("description", hotaList[p1].description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_object_cleaning)
        val image: ImageView = view.findViewById(R.id.object_hero_image)
        val name: TextView = view.findViewById(R.id.object_hero_name)
    }
}