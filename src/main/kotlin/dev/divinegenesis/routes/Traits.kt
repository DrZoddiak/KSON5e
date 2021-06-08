package dev.divinegenesis.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Traits(
    val index: String?,
    val races: List<Results>?,
    val subraces: List<JsonObject>?,
    val name: String?,
    val desc: List<String>?,
    val proficiencies: JsonArray?,
    val url: String?
)
