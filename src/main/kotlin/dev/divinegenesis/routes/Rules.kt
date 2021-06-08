package dev.divinegenesis.routes

data class Rules(
    val name: String?,
    val index: String?,
    val desc: String?,
    val subsections: List<Results>?,
    val url: String?
)
