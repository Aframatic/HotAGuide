package com.example.hotaguide.Category.Creatures.CreatureList.HOTACreatureList

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class CreatureListDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTACreatureList> {
        val list = mutableListOf<HOTACreatureList>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM creatures WHERE category_list_id = ? and upgrade = 0",
            arrayOf(categoryId.toString())
        )

        var id: Int
        var name: String
        var image: String
        var attack: Int
        var defense: Int
        var ammo: Int
        var damage: String
        var health: Int
        var speed: Int
        var specificity: String


        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))
            attack = cursor.getInt(cursor.getColumnIndex("attack"))
            defense = cursor.getInt(cursor.getColumnIndex("defense"))
            ammo = cursor.getInt(cursor.getColumnIndex("ammo"))
            damage = cursor.getString(cursor.getColumnIndex("damage"))
            health = cursor.getInt(cursor.getColumnIndex("health"))
            speed = cursor.getInt(cursor.getColumnIndex("speed"))
            specificity = cursor.getString(cursor.getColumnIndex("specificity"))

            list.add(
                HOTACreatureList(
                    id,
                    name,
                    image,
                    attack,
                    defense,
                    ammo,
                    damage,
                    health,
                    speed,
                    specificity
                )
            )
        }

        cursor.close()
        db.close()

        return list
    }
}