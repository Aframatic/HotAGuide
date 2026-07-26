package com.example.hotaguide.db

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DbNotHelper(context: Context?) :
    SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private val forcedVersion: Int = DATABASE_VERSION

    companion object {
        private const val DATABASE_NAME = "hotaguide.db"
        private const val DATABASE_VERSION = 9

    }

    init {
        setForcedUpgrade(forcedVersion)
    }

}