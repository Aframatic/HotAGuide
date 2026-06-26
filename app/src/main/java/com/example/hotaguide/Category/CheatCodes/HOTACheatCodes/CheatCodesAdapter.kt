package com.example.hotaguide.Category.CheatCodes.HOTACheatCodes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.CheatCodes.CheatCodeDescription.CheatCodeDescriptionActivity
import com.example.hotaguide.Category.Spells.SpellsList.SpellDescription.SpellDescriptionActivity
import com.example.hotaguide.R

class CheatCodesAdapter(
    private val hotaList: List<HOTACheatCodes>, var context: Context
) : RecyclerView.Adapter<CheatCodesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_cheat_codes_list, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.description.text = hotaList[p1].description

        p0.bt.setOnClickListener {
            val intent = Intent(context, CheatCodeDescriptionActivity::class.java)
            intent.putExtra("name", hotaList[p1].name)
            intent.putExtra("text", hotaList[p1].text)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_pattern)
        var description: TextView = view.findViewById(R.id.description_cheat)
    }
}