package dev.divinegenesis.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject

/**
 * @author DrZoddiak
 * Finished 6/7/2021
 */
data class Classes(
    val index: String?,
    val name: String?,
    val hit_die: Int,
    val proficiency_choices: List<ProficiencyChoices>?,
    val proficiencies: List<Results>?,
    val saving_throws: List<Results>?,
    val starting_equipment: List<StartingEquipment>?,
    val starting_equipment_options: List<ClassesStartingEquipment>?,
    val class_levels: String?,
    val subclasses: List<Results>?,
    val spellcasting: List<Spellcasting>?,
    val spells: String?,
    val url: String?
) {}

data class ProficiencyChoices(
    val choose: Int?,
    val type: String?,
    val from: List<Results>? //Same format
) {}

data class ClassesStartingEquipment(
    val equipment: List<Results>?,
    val quantity: Int?
) {}

data class Spellcasting(
    val info: List<Info>?,
    val level: Int?,
    val spellcasting_ability: List<Results>?
) {}

data class Info(

    val desc: String?,
    val name: String?

) {}