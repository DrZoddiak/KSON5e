package dev.divinegenesis.routes

data class BaseRequest(

    //This works for a lot of things
    //Going to list anything that doesn't

    var count: Int?,
    var results: List<Results>?
) {}

data class Results(
    var index: String? = null,
    var name: String? = null,
    var url: String? = null
) {}

data class orange(
    val index: String?,
    val name: String?,
    val desc: List<String>?,
    val url: String?
)