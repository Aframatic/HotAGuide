package com.example.hotaguide.Category.Artefacts.HOTAArtefact

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper
import com.example.hotaguide.db.DbNotHelper

class ArtefactCategoryDatabase (context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTAArtefactCategory> {
        val list = mutableListOf<HOTAArtefactCategory>()
        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.rawQuery(
            "SELECT * FROM category_list WHERE category_id = ?",
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