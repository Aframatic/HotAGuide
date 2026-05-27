package com.example.hotaguide.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "hotaguide.db"
        private const val DATABASE_VERSION = 2

        private const val CREATE_TABLE_PATTERN = """
            CREATE TABLE pattern (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                pattern_name TEXT
            )
        """

        private const val CREATE_TABLE_CATEGORY = """
            CREATE TABLE category (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                category_name TEXT
            )
        """

        private const val CREATE_TABLE_CATEGORY_STARTERS_HERO = """
            CREATE TABLE starterHero (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                hero_name TEXT,
                hero_image TEXT,
                hero_skill_image_1 TEXT,
                hero_skill_image_2 TEXT,
                special_image TEXT,
                creature_image_1 TEXT,
                creature_image_2 TEXT,
                creature_image_3 TEXT,
                attack_skill INTEGER,
                defense_skill INTEGER,
                power_skill INTEGER,
                knowledge_skill INTEGER,
                hero_skill_name_1 TEXT,
                hero_skill_name_2 TEXT,
                special_name TEXT,
                special_description TEXT,
                creature_count_1 TEXT,
                creature_count_2 TEXT,
                creature_count_3 TEXT,
                category_list_id INTEGER REFERENCES category_list (id)
            )
        """

        private const val CREATE_TABLE_CATEGORY_ARTEFACTS = """
            CREATE TABLE artefacts (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                image TEXT,
                description TEXT,
                category_list_id INTEGER REFERENCES category_list (id)
            )
        """

        private const val CREATE_TABLE_CATEGORY_LIST = """
            CREATE TABLE category_list (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                image TEXT,
                category_id INTEGER REFERENCES category (id)
            )
        """

        private const val CREATE_TABLE_CATEGORY_ARTEFACT_COLLECTION = """
            CREATE TABLE artefacts_collection (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                image TEXT,
                description TEXT,
                category_id INTEGER REFERENCES category_list (id)
            )
        """

        private const val CREATE_TABLE_CATEGORY_ARTEFACT_ITEM_COLLECTION = """
            CREATE TABLE artefacts_item_collection (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                artefact_collection_id INTEGER REFERENCES artefact_collection (id),
                artefact_id INTEGER REFERENCES artefacts (id)
            )
        """

        private const val CREATE_TABLE_CREATURES = """
            CREATE TABLE creatures (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                image TEXT,
                attack INTEGER,
                defense INTEGER,
                ammo INTEGER,
                damage TEXT,
                health INTEGER,
                speed INTEGER,
                upgrade INTEGER,
                specificity TEXT DEFAULT "Нет",
                category_list_id INTEGER REFERENCES category_list (id)
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_PATTERN)
        db.execSQL(CREATE_TABLE_CATEGORY)
        db.execSQL(CREATE_TABLE_CATEGORY_STARTERS_HERO)
        db.execSQL(CREATE_TABLE_CATEGORY_ARTEFACTS)
        db.execSQL(CREATE_TABLE_CATEGORY_LIST)
        db.execSQL(CREATE_TABLE_CATEGORY_ARTEFACT_COLLECTION)
        db.execSQL(CREATE_TABLE_CATEGORY_ARTEFACT_ITEM_COLLECTION)
        db.execSQL(CREATE_TABLE_CREATURES)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS pattern")
        db.execSQL("DROP TABLE IF EXISTS category")
        db.execSQL("DROP TABLE IF EXISTS starterHero")
        db.execSQL("DROP TABLE IF EXISTS artefacts")
        db.execSQL("DROP TABLE IF EXISTS category_list")
        db.execSQL("DROP TABLE IF EXISTS artefacts_collection")
        db.execSQL("DROP TABLE IF EXISTS artefacts_item_collection")
        db.execSQL("DROP TABLE IF EXISTS creatures")
        onCreate(db)
    }
}