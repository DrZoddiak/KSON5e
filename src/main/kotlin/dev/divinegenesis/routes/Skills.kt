package dev.divinegenesis.routes

data class Skills(
    val index: String?,
    val name: String?,
    val desc: List<String>?,
    val ability_score: List<Results>?,
    val url: String?
)
