package dev.divinegenesis.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Proficiencies(
    val index: String?,
    val type: String?,
    val name: String?,
    val classes: JsonArray?,
    val races: JsonArray?,
    val url: String?,
    val references: List<JsonObject>?
)

data class References(
    val index: String?,
    val type: String?,
    val name: String?,
    val url: String?
)
