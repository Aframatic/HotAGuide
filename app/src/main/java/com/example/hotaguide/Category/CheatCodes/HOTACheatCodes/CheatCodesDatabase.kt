package com.example.hotaguide.Category.CheatCodes.HOTACheatCodes

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class CheatCodesDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(): List<HOTACheatCodes> {
        val list = mutableListOf<HOTACheatCodes>()
        val db = databaseHelper.readableDatabase

        val cursor = db.query(
            "cheat_codes",
            null,
            null,
            null,
            null,
            null,
            null
        )

        var name: String
        var description: String
        var text: String

        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndex("name"))
            description = cursor.getString(cursor.getColumnIndex("description"))
            text = cursor.getString(cursor.getColumnIndex("text"))

            list.add(HOTACheatCodes(name, description, text))
        }

        cursor.close()
        db.close()

        return list
    }
}