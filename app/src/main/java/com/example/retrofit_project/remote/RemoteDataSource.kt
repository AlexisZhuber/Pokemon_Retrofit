package com.example.retrofit_project.remote

import com.example.retrofit_project.model.PokemonDetailResponse
import com.example.retrofit_project.model.PokemonListResponse

/**
 * RemoteDataSource handles data fetching from the PokeAPI using Retrofit.
 *
 * It acts as an intermediary to retrieve a paginated list of Pokémon,
 * detailed information for a specific Pokémon, and to search for Pokémon by name or ID.
 */
class RemoteDataSource {
    // Instance of the API service provided by RetrofitInstance
    private val apiService = RetrofitInstance.api

    /**
     * Retrieves a paginated list of Pokémon.
     *
     * @param offset The starting index for the Pokémon list.
     * @param limit The number of Pokémon to fetch.
     * @return A [PokemonListResponse] containing Pokémon list and pagination data.
     */
    suspend fun fetchPokemonPage(offset: Int, limit: Int): PokemonListResponse {
        return apiService.fetchPokemonPage(offset, limit)
    }

    /**
     * Retrieves detailed information for a specific Pokémon using its detail URL.
     *
     * The provided URL is assumed to end with the Pokémon's ID or name.
     * This method extracts that identifier and makes the corresponding API call.
     *
     * @param detailUrl The full URL to the Pokémon's detail endpoint.
     * @return A [PokemonDetailResponse] containing detailed information about the Pokémon.
     */
    suspend fun fetchPokemonDetail(detailUrl: String): PokemonDetailResponse {
        // Extract the ID or name from the URL (assuming it ends with "/")
        val idOrName = detailUrl.trimEnd('/').substringAfterLast("/")
        return apiService.fetchPokemonDetail(idOrName)
    }

    /**
     * Searches for a Pokémon by its exact name or ID.
     *
     * This method directly calls the API service with the provided query,
     * which must exactly match the Pokémon's name or ID.
     *
     * @param query The exact name or ID of the Pokémon.
     * @return A [PokemonDetailResponse] with the Pokémon's detailed information.
     */
    suspend fun fetchPokemonByNameOrId(query: String): PokemonDetailResponse {
        return apiService.fetchPokemonDetail(query)
    }
}
