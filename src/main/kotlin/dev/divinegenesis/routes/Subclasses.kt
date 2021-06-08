package dev.divinegenesis.routes

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Subclasses(
    val index: String?,
    @SerializedName("class") //Reserved Name
    val clazz: List<JsonObject>?,
    val name: String?,
    val subclass_flavor: String?,
    val desc: List<String>?,
    val subclass_levels: String?,
    val url: String?
)
