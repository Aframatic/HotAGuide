package com.example.hotaguide.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "HOTAGuide.db"
        private const val DATABASE_VERSION = 2

        private const val CREATE_TABLE_PATTERN = """
            CREATE TABLE hotaPattern (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_PATTERN)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS hotaPattern")
        onCreate(db)
    }
}