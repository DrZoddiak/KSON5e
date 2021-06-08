package dev.divinegenesis.routes

import com.google.gson.JsonObject

data class Spells(
    val index: String?,
    val name: String?,
    val desc: List<String>?,
    val higher_level: List<JsonObject>?,
    val range: String?,
    val components: List<JsonObject>?,
    val material: String?,
    val ritual: Boolean?,
    val duration: String?,
    val concentration: Boolean?,
    val casting_time: String?,
    val level: Int?,
    val heal_at_slot_level: List<JsonObject>?,
    val school: Results?,
    val classes: List<JsonObject>?,
    val subclasses: List<Results>?,
    val url: String
)
