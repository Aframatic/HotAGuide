package com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.HOTACollection

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.ItemCollection.ItemCollectionActivity
import com.example.hotaguide.R

class CollectionAdapter(
    private val hotaList: List<HOTACollection>, var context: Context
) : RecyclerView.Adapter<CollectionAdapter.MyViewHolder>() {

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
            val intent = Intent(context, ItemCollectionActivity::class.java)
            intent.putExtra("collection_id", hotaList[p1].id)
            intent.putExtra("collection_name", hotaList[p1].name)
            intent.putExtra("collection_image", hotaList[p1].image)
            intent.putExtra("collection_description", hotaList[p1].description)
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