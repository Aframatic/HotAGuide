package com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.HOTACollection

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class CollectionDatabase (context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(idCategory: Int): List<HOTACollection> {
        val list = mutableListOf<HOTACollection>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM artefact_collection WHERE list_id = ?",
            arrayOf(idCategory.toString())
        )

        var id: Int
        var name: String
        var image: String
        var description: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))
            description = cursor.getString(cursor.getColumnIndex("description"))
            list.add(HOTACollection(id, name, image, description))
        }

        cursor.close()
        db.close()

        return list
    }
}