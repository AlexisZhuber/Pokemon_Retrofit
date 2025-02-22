package com.example.retrofit_project.remote

import com.example.retrofit_project.model.PokemonDetailResponse
import com.google.gson.*
import java.lang.reflect.Type

/**
 * Custom deserializer for converting JSON responses into a PokemonDetailResponse.
 *
 * This deserializer extracts the Pokémon's id, name, height, weight, types, and front sprite URL
 * from the JSON response provided by the PokeAPI.
 */
class PokemonDetailResponseDeserializer : JsonDeserializer<PokemonDetailResponse> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): PokemonDetailResponse {
        val jsonObject = json.asJsonObject

        // Extract basic properties
        val id = jsonObject.get("id").asInt
        val name = jsonObject.get("name").asString
        val height = jsonObject.get("height").asInt
        val weight = jsonObject.get("weight").asInt

        // Extract the list of types
        val typesList = mutableListOf<String>()
        val typesArray = jsonObject.getAsJsonArray("types")
        for (element in typesArray) {
            val typeObj = element.asJsonObject.getAsJsonObject("type")
            val typeName = typeObj.get("name").asString
            typesList.add(typeName)
        }

        // Extract the sprite URL (front_default image)
        val spritesObj = jsonObject.getAsJsonObject("sprites")
        val spriteUrl = if (spritesObj.has("front_default") && !spritesObj.get("front_default").isJsonNull)
            spritesObj.get("front_default").asString else ""

        // Return the populated PokemonDetailResponse object
        return PokemonDetailResponse(
            id = id,
            name = name,
            height = height,
            weight = weight,
            types = typesList,
            spriteUrl = spriteUrl
        )
    }
}
