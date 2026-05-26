package com.example.hotaguide.Category.artefacts.HOTAArtefact

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class ArtefactCategoryDatabase (context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTAArtefactCategory> {
        val list = mutableListOf<HOTAArtefactCategory>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM artefacts_list WHERE category_id = ?",
            arrayOf(categoryId.toString())
        )

        var id: Int
        var name: String
        var image: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))
            list.add(HOTAArtefactCategory(id, name, image))
        }

        cursor.close()
        db.close()

        return list
    }
}