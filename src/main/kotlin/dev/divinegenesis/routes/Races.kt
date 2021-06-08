package dev.divinegenesis.routes

import com.google.gson.JsonArray

data class Races(
    val index: String?,
    val name: String?,
    val speed: Int?,
    val ability_bonuses: List<AbilityBonuses>?,
    val alignment: String?,
    val age: String?,
    val size: String?,
    val size_description: String?,
    val starting_proficiencies: JsonArray?,
    val languages: List<Results>?,
    val language_desc: String?,
    val traits: List<Results>?,
    val trait_options: List<TraitOptions>?,
    val subraces: JsonArray?,
    val url: String?
)

data class AbilityBonuses(
    val ability_score: List<Results>?,
    val bonus: Int?
)

data class TraitOptions(
    val from: List<Results>?,
    val choose: Int?,
    val type: String?
)


