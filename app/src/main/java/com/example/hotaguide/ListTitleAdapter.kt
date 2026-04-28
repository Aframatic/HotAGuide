package com.example.hotaguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.HOTAPattern.HOTAPatternDatabase

class ListTitleAdapter(
    private val hotaList: List<HOTAPatternDatabase.HOTAPattern>, var context: Context
) : RecyclerView.Adapter<ListTitleAdapter.ListTitleViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListTitleViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_title, p0, false)
        return ListTitleViewHolder(view)
    }

    override fun onBindViewHolder(p0: ListTitleViewHolder, p1: Int) {
        val hota = hotaList[p1]
        p0.bind(hota)
    }

    override fun getItemCount(): Int = hotaList.size

    class ListTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pattern: HOTAPatternDatabase.HOTAPattern) {
            itemView.findViewById<TextView>(R.id.hota_list_pattern).text = pattern.text
        }
    }
}