package dev.divinegenesis.routes

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class StartingEquipment(
    val name: String?,
    @SerializedName("class") //Reserved Name
    val clazz: List<Results>?,
    val starting_equipment: List<EquipmentStarting>?,
    val starting_equipment_options: List<JsonObject>?,
    val url: String?
)

data class EquipmentStarting(
    val equipment: List<Results>?,
    val quantity: Int?
)
