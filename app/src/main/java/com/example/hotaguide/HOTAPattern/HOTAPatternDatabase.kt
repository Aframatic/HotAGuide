package com.example.hotaguide.HOTAPattern

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.hotaguide.db.DbHelper

class HOTAPatternDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    fun insert(text: String) {
        val db = databaseHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", text)
        }

        db.insert("hotaPattern", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun get(): List<HOTAPattern> {
        val list = mutableListOf<HOTAPattern>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM hotaPattern", null)

        var id: Int
        var name: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            name = cursor.getString(cursor.getColumnIndex("name"))
            list.add(HOTAPattern(id, name))
        }

        cursor.close()
        db.close()

        return list
    }

    fun delete(id: Int) {
        val db = databaseHelper.writableDatabase
        db.delete("hotaPattern", "id = ?", arrayOf(id.toString()))
        db.close()
    }

    data class HOTAPattern(val id: Int, val text: String)
}