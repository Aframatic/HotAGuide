package com.example.hotaguide.Category.CastlesStarters.HeroesCastle.HOTAHeroesCastle

import android.annotation.SuppressLint
import android.content.Context
import com.example.hotaguide.db.DbHelper

class HeroesCastleDatabase(context: Context) {
    private val databaseHelper = DbHelper(context)

    @SuppressLint("Range")
    fun get(categoryId: Int): List<HOTAHeroesCastle> {
        val list = mutableListOf<HOTAHeroesCastle>()
        val db = databaseHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM starterHero WHERE category_list_id = ?",
            arrayOf(categoryId.toString())
        )

        var id: Int
        var heroName: String
        var heroImage: String
        var heroSkillImage1: String
        var heroSkillImage2: String
        var specialImage: String
        var creatureImage1: String
        var creatureImage2: String
        var creatureImage3: String
        var attackSkill: Int
        var defenseSkill: Int
        var powerSkill: Int
        var knowledgeSkill: Int
        var heroSkillName1: String
        var heroSkillName2: String
        var specialName: String
        var specialDescription: String
        var creatureCount1: String
        var creatureCount2: String
        var creatureCount3: String

        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"))
            heroName = cursor.getString(cursor.getColumnIndex("hero_name"))
            heroImage = cursor.getString(cursor.getColumnIndex("hero_image"))
            heroSkillImage1 = cursor.getString(cursor.getColumnIndex("hero_skill_image_1"))
            heroSkillImage2 = cursor.getString(cursor.getColumnIndex("hero_skill_image_2"))
            specialImage = cursor.getString(cursor.getColumnIndex("special_image"))
            creatureImage1 = cursor.getString(cursor.getColumnIndex("creature_image_1"))
            creatureImage2 = cursor.getString(cursor.getColumnIndex("creature_image_2"))
            creatureImage3 = cursor.getString(cursor.getColumnIndex("creature_image_3"))
            attackSkill = cursor.getInt(cursor.getColumnIndex("attack_skill"))
            defenseSkill = cursor.getInt(cursor.getColumnIndex("defense_skill"))
            powerSkill = cursor.getInt(cursor.getColumnIndex("power_skill"))
            knowledgeSkill = cursor.getInt(cursor.getColumnIndex("knowledge_skill"))
            heroSkillName1 = cursor.getString(cursor.getColumnIndex("hero_skill_name_1"))
            heroSkillName2 = cursor.getString(cursor.getColumnIndex("hero_skill_name_2"))
            specialName = cursor.getString(cursor.getColumnIndex("special_name"))
            specialDescription = cursor.getString(cursor.getColumnIndex("special_description"))
            creatureCount1 = cursor.getString(cursor.getColumnIndex("creature_count_1"))
            creatureCount2 = cursor.getString(cursor.getColumnIndex("creature_count_2"))
            creatureCount3 = cursor.getString(cursor.getColumnIndex("creature_count_3"))
            list.add(
                HOTAHeroesCastle(
                    id,
                    heroName,
                    heroImage,
                    heroSkillImage1,
                    heroSkillImage2,
                    specialImage,
                    creatureImage1,
                    creatureImage2,
                    creatureImage3,
                    attackSkill,
                    defenseSkill,
                    powerSkill,
                    knowledgeSkill,
                    heroSkillName1,
                    heroSkillName2,
                    specialName,
                    specialDescription,
                    creatureCount1,
                    creatureCount2,
                    creatureCount3
                )
            )
        }

        cursor.close()
        db.close()

        return list
    }
}