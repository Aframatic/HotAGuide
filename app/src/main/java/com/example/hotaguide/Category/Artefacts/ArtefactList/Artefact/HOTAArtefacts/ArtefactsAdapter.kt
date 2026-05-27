package com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.HOTAArtefacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.ItemArtefact.ItemArtefactActivity
import com.example.hotaguide.R

class ArtefactsAdapter(
    private val hotaList: List<HOTAArtefacts>, var context: Context
) : RecyclerView.Adapter<ArtefactsAdapter.MyViewHolder>() {

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

        p0.artefactImage.setImageResource(imageId)

        p0.bt.setOnClickListener {
            val intent = Intent(context, ItemArtefactActivity::class.java)
            intent.putExtra("artefact_name", hotaList[p1].name)
            intent.putExtra("artefact_image", hotaList[p1].image)
            intent.putExtra("artefact_description", hotaList[p1].description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bt: LinearLayout = view.findViewById(R.id.button_pattern)
        var artefactImage: ImageView = view.findViewById(R.id.artefact_image)
    }

}