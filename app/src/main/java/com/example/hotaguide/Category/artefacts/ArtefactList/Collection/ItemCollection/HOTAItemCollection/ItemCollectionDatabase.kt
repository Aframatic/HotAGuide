package com.example.hotaguide.Category.artefacts.ArtefactList.Collection.ItemCollection.HOTAItemCollection

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.Category.artefacts.ArtefactList.Collection.HOTACollection.HOTACollection
import com.example.hotaguide.Category.artefacts.HOTAArtefact.HOTAArtefacts
import com.example.hotaguide.db.DbHelper

class ItemCollectionDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range", "Recycle")
    fun get(idCollection: Int): List<HOTAItemCollection> {
        val list = mutableListOf<HOTAItemCollection>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM artefact_item_collection WHERE artefact_collection_id = ?",
            arrayOf(idCollection.toString())
        )

        var artefactId: Int
        var artefactItem: String
        var artefactImage: String
        val exoPlanets = mutableListOf<Int>()

        while (cursor.moveToNext()) {
            artefactId = cursor.getInt(cursor.getColumnIndex("artefact_id"))
            exoPlanets.add(artefactId)
        }
        cursor.close()

        for (i in exoPlanets) {
            val cursor2 = db.rawQuery(
                "SELECT * FROM artefacts WHERE id = ?",
                arrayOf(i.toString())
            )

            while (cursor2.moveToNext()) {
                artefactItem = cursor2.getString(cursor2.getColumnIndex("name"))
                artefactImage = cursor2.getString(cursor2.getColumnIndex("image"))
                list.add(HOTAItemCollection(artefactItem, artefactImage))
            }

            cursor2.close()
        }

        db.close()

        return list
    }

}