package com.example.hotaguide.Category.Spells.SpellsList.HOTASpellsList

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class SpellsListDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTASpellsList> {
        val list = mutableListOf<HOTASpellsList>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM spells WHERE category_list_id = ?",
            arrayOf(categoryId.toString())
        )

        var id: Int
        var name: String
        var image: String
        var costWithSkill: Int
        var costWithoutSkill: Int
        var basic: String
        var advanced: String
        var expert: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            image = cursor.getString(cursor.getColumnIndex("image"))
            costWithSkill = cursor.getInt(cursor.getColumnIndex("cost_with_skill"))
            costWithoutSkill = cursor.getInt(cursor.getColumnIndex("cost_without_skill"))
            basic = cursor.getString(cursor.getColumnIndex("basic"))
            advanced = cursor.getString(cursor.getColumnIndex("advanced"))
            expert = cursor.getString(cursor.getColumnIndex("expert"))
            list.add(
                HOTASpellsList(
                    id,
                    name,
                    image,
                    costWithSkill,
                    costWithoutSkill,
                    basic,
                    advanced,
                    expert
                )
            )
        }

        cursor.close()
        db.close()

        return list
    }
}