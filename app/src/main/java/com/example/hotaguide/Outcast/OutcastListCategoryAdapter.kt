package com.example.hotaguide.Outcast

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.HOTAPattern.HOTAPattern
import com.example.hotaguide.R

class OutcastListCategoryAdapter (
    private val hotaList: List<HOTAPattern>, var context: Context
) : RecyclerView.Adapter<OutcastListCategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text = hotaList[p1].name

        p0.bt.setOnClickListener {
            val intent = Intent(context, OutcastCategoryActivity::class.java)
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