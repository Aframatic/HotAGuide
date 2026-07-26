package com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper
import com.example.hotaguide.db.DbNotHelper

class CreatureListDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTACreatureList> {
        val list = mutableListOf<HOTACreatureList>()
        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.rawQuery(
            "SELECT * FROM creatures WHERE category_list_id = ? and upgrade = 0",
            arrayOf(categoryId.toString())
        )

        var id: Int
        var name: String
        var image: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))

            list.add(
                HOTACreatureList(
                    id,
                    name,
                    image
                )
            )
        }

        cursor.close()
        db.close()

        return list
    }
}