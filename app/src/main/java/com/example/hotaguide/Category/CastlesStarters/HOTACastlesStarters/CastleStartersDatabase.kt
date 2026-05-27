package com.example.hotaguide.Category.CastlesStarters.HOTACastlesStarters

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class CastleStartersDatabase (context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTACastlesStarters> {
        val list = mutableListOf<HOTACastlesStarters>()
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
            list.add(HOTACastlesStarters(id, name, image))
        }

        cursor.close()
        db.close()

        return list
    }
}