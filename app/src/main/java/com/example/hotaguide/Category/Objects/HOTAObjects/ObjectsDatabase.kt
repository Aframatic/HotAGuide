package com.example.hotaguide.Category.Objects.HOTAObjects

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbNotHelper

class ObjectsDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun getObjects(): List<HOTAObject> {
        val list = mutableListOf<HOTAObject>()

        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.query(
            "objects",
            null,
            null,
            null,
            null,
            null,
            null
        )

        var id: Int
        var name: String
        var image: String
        var imageGrid: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))
            imageGrid = cursor.getString(cursor.getColumnIndex("object_grid"))
            list.add(HOTAObject(id, name, image, imageGrid))
        }

        cursor.close()
        db.close()

        return list
    }
}