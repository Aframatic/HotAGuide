package com.example.hotaguide.Category.Creatures.HOTACreatures

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class CreaturesDatabase (context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTACreatures> {
        val list = mutableListOf<HOTACreatures>()
        val db = databaseHelper.readableDatabase

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
            list.add(HOTACreatures(id, name, image))
        }

        cursor.close()
        db.close()

        return list
    }
}