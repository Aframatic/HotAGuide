package com.example.hotaguide.Category.HOTACategory

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper
import com.example.hotaguide.db.DbNotHelper

class CategoryDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)


    @SuppressLint("Range")
    fun getCategory(): List<HOTACategory> {
        val list = mutableListOf<HOTACategory>()
        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.query(
            "category",
            null,
            null,
            null,
            null,
            null,
            null
        )

        var id: Int
        var name: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("category_name"))
            list.add(HOTACategory(id, name))
        }

        cursor.close()
        db.close()

        return list
    }
}