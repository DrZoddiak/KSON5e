package dev.divinegenesis.routes

data class Conditions( //Should work for damage-types as well
    val index: String?,
    val name: String?,
    val desc: List<String>?,
    val url: String?
) {}