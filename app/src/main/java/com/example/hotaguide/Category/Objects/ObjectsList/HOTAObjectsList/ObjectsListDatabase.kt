package com.example.hotaguide.Category.Objects.ObjectsList.HOTAObjectsList

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.Category.Artefacts.ArtefactList.Collection.ItemCollection.HOTAItemCollection.HOTAItemCollection
import com.example.hotaguide.db.DbNotHelper

class ObjectsListDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range", "Recycle")
    fun getObjects(idCollection: Int): List<HOTAObjectList> {
        val list = mutableListOf<HOTAObjectList>()
        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.rawQuery(
            "SELECT * FROM object_item_list WHERE object_id = ?",
            arrayOf(idCollection.toString())
        )

        var id: Int
        var name: String
        val exoPlanets = mutableListOf<Int>()

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("object_list_id"))
            exoPlanets.add(id)
        }
        cursor.close()

        for (i in exoPlanets) {
            val cursor2 = db.rawQuery(
                "SELECT * FROM object_list WHERE id = ?",
                arrayOf(i.toString())
            )

            while (cursor2.moveToNext()) {
                id = cursor2.getInt(cursor2.getColumnIndex("id"))
                name = cursor2.getString(cursor2.getColumnIndex("description"))
                list.add(HOTAObjectList(id, name))
            }

            cursor2.close()
        }

        db.close()

        return list
    }
}