package com.example.retrofit_project.remote

import com.example.retrofit_project.model.PokemonDetailResponse
import com.example.retrofit_project.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * PokeApiService defines the endpoints for interacting with the PokeAPI.
 *
 * This interface uses Retrofit annotations to map HTTP requests to functions,
 * allowing for asynchronous network calls to retrieve Pokémon data.
 */
interface PokeApiService {

    /**
     * Retrieves a paginated list of Pokémon.
     *
     * Sends a GET request to the "pokemon" endpoint with the provided offset and limit.
     * The offset parameter specifies the starting index, while limit determines the number of items.
     *
     * @param offset The starting index for the Pokémon list.
     * @param limit The maximum number of Pokémon to retrieve.
     * @return A [PokemonListResponse] containing the list of Pokémon and pagination info.
     */
    @GET("pokemon")
    suspend fun fetchPokemonPage(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListResponse

    /**
     * Retrieves detailed information for a specific Pokémon.
     *
     * Sends a GET request to the "pokemon/{idOrName}" endpoint where {idOrName} can be either
     * the Pokémon's ID or its name. The API returns detailed data including stats, types,
     * and sprites.
     *
     * @param idOrName The ID or name of the Pokémon.
     * @return A [PokemonDetailResponse] containing detailed information about the Pokémon.
     */
    @GET("pokemon/{idOrName}")
    suspend fun fetchPokemonDetail(
        @Path("idOrName") idOrName: String
    ): PokemonDetailResponse
}
