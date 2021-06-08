package dev.divinegenesis.routes

import com.google.gson.JsonObject

data class Languages(
        val index: String?,
        val name: String?,
        val type: String?,
        val typical_speakers: List<JsonObject>?,
        val script: String?,
        val url: String?
)
