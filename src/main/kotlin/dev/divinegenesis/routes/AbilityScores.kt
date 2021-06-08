package dev.divinegenesis.routes

data class AbilityScores(
    var index: String?,
    var name: String?,
    var full_name: String?,
    var desc: List<String>?,
    var skills: List<Results>?,
    var url: String?
) {}