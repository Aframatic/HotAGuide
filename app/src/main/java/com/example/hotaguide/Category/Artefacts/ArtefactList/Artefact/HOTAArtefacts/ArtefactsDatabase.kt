package com.example.hotaguide.Category.Artefacts.ArtefactList.Artefact.HOTAArtefacts

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper
import com.example.hotaguide.db.DbNotHelper

class ArtefactsDatabase (context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun get(idCategory: Int): List<HOTAArtefacts> {
        val list = mutableListOf<HOTAArtefacts>()
        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.rawQuery(
            "SELECT * FROM artefacts WHERE category_list_id = ?",
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
            list.add(HOTAArtefacts(id, name, image, description))
        }

        cursor.close()
        db.close()

        return list
    }
}