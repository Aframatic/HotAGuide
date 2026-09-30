package com.example.hotaguide.Category.Objects.HOTAObjects

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.Category.Objects.ObjectsList.ObjectCleaning.HOTAObjectsCleaning.HOTAObjectCleaning
import com.example.hotaguide.db.DbNotHelper

class ObjectsCleaningDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun getObjects(idCollection: Int): List<HOTAObjectCleaning> {
        val list = mutableListOf<HOTAObjectCleaning>()

        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.rawQuery(
            "SELECT * FROM object_cleaning WHERE object_id = ?",
            arrayOf(idCollection.toString())
        )

        var id: Int
        var nameHero: String
        var imageHero: String
        var startingArmyImage: String
        var grid: String
        var description: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            nameHero = cursor.getString(cursor.getColumnIndex("name_hero"))
            imageHero = cursor.getString(cursor.getColumnIndex("image_hero"))
            startingArmyImage = cursor.getString(cursor.getColumnIndex("starting_army_image"))
            grid = cursor.getString(cursor.getColumnIndex("grid"))
            description = cursor.getString(cursor.getColumnIndex("description"))
            list.add(
                HOTAObjectCleaning(
                    id,
                    nameHero,
                    imageHero,
                    startingArmyImage,
                    grid,
                    description
                )
            )
        }

        cursor.close()
        db.close()

        return list
    }
}