package com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.ItemCollection.HOTAItemCollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotaguide.R

class ItemCollectionAdapter(
    private val hotaList: List<HOTAItemCollection>, var context: Context
) : RecyclerView.Adapter<ItemCollectionAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.activity_jebus_collection_item, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.collectionItem.text = hotaList[p1].artefactItem

        val imageId = context.resources.getIdentifier(
            hotaList[p1].artefactImage,
            "drawable",
            context.packageName
        )

        p0.collectionImage.setImageResource(imageId)
    }

    override fun getItemCount(): Int {
        return hotaList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var collectionItem: TextView = view.findViewById(R.id.collection_item)
        val collectionImage: ImageView = view.findViewById(R.id.collection_image)
    }

}