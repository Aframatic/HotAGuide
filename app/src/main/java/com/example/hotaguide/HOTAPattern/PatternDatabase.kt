package com.example.hotaguide.HOTAPattern

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbNotHelper

class PatternDatabase(context: Context) {
    private val databaseNothelper = DbNotHelper(context)

    @SuppressLint("Range")
    fun getPatterns(): List<HOTAPattern> {
        val list = mutableListOf<HOTAPattern>()

        val db = databaseNothelper.getReadableDatabase()

        val cursor = db.query(
            "pattern",
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
            name = cursor.getString(cursor.getColumnIndex("pattern_name"))
            list.add(HOTAPattern(id, name))
        }

        cursor.close()
        db.close()

        return list
    }
}