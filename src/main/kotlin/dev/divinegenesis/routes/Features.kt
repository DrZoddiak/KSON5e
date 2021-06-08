package dev.divinegenesis.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Features(
    val index: String?,
    @SerializedName("class") //Class is a reserved word
    val clazz: List<JsonObject>?,
    val name: String?,
    val level: Int?,
    val prerequisites: JsonArray?, // FIXME: 6/8/2021 Not sure what this is supposed to be, waiting for an error. 
    val desc: List<String>?,
    val url: String?
)
