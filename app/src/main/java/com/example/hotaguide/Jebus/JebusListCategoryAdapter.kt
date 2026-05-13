package com.example.hotaguide.Jebus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.HOTAPattern.HOTAPattern
import com.example.hotaguide.Jebus.artefacts.JebusArtefactCategoryActivity
import com.example.hotaguide.Jebus.objects.JebusObjectCategoryActivity
import com.example.hotaguide.Jebus.starters.JebusStarterCategoryActivity
import com.example.hotaguide.R

class JebusListCategoryAdapter(
    private val hotaList: List<HOTAPattern>, var context: Context
) : RecyclerView.Adapter<JebusListCategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].name

        p0.bt.setOnClickListener {
            var intent = Intent()

            if (p0.name.text == "Стартеры") {
                intent = Intent(context, JebusStarterCategoryActivity::class.java)
            }

            if (p0.name.text == "Объекты") {
                intent =  Intent(context, JebusObjectCategoryActivity::class.java)
            }

            if (p0.name.text == "Артефакты") {
                intent =  Intent(context, JebusArtefactCategoryActivity::class.java)
            }
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