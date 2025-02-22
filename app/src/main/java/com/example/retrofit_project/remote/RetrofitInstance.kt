package com.example.retrofit_project.remote

import com.example.retrofit_project.model.PokemonDetailResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RetrofitInstance is a singleton object that sets up the Retrofit client for the PokeAPI.
 *
 * It configures Retrofit with a custom Gson converter that registers a deserializer for
 * PokemonDetailResponse. This ensures that the JSON responses from the API are correctly
 * mapped to our model classes.
 */
object RetrofitInstance {

    // Create a custom Gson instance with a registered deserializer for PokemonDetailResponse
    private val gson = GsonBuilder()
        .registerTypeAdapter(PokemonDetailResponse::class.java, PokemonDetailResponseDeserializer())
        .create()

    // Lazy initialization of the Retrofit instance with the base URL and custom Gson converter
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    /**
     * Exposes the PokeApiService to perform API calls.
     *
     * This property lazily creates the API service instance from the Retrofit client.
     */
    val api: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}
