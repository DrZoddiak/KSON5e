package dev.divinegenesis.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Monsters(
    var index: String?,
    var name: String?,
    var size: String?,
    var type: String?,
    var subType: String?,
    var alignment: String?,
    var armor_class: Int?,
    var hit_points: Int?,
    var hit_dice: String?,
    var speed: Any,
    var strength: Int?,
    var dexterity: Int?,
    var constitution: Int?,
    var intelligence: Int?,
    var wisdom: Int?,
    var charisma: Int?,
    var proficiencies: List<BaseRequest>?, //Same array as root
    var damage_vulnerabilities: JsonArray?,
    var damage_resistance: JsonArray?,
    var damage_immunities: JsonArray?,
    var condition_immunities: JsonArray?,
    var senses: Senses,
    var languages: String?,
    var challenge_rating: Double?,
    var xp: Int?,
    var special_abilities: List<SpecialAbilities>?,
    var actions: List<Weapons>?,
    var url: String?
)

data class Senses(
    var darkvision: String?,
    var passive_perception: Int?
)

data class SpecialAbilities(
    var name: String?,
    var desc: String?
)

data class Weapons(
    var name: String?,
    var desc: String?,
    var attack_bonus: Int?,
    var damage: List<Damage>?
)

data class Damage(
    var damage_type: JsonObject, //Same as results
    var damage_dice: String?
)