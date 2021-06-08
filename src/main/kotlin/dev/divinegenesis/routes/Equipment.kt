package dev.divinegenesis.routes


data class Equipment(
    val index: String?,
    val name: String?,
    val equipmentCategory: List<Results>?,
    val gear_category: List<Results>?,
    val cost: List<Cost>?,
    val weight: Int?,
    val url: String?
)

data class Cost(
    val quantity: Int?,
    val unit: String?
)
