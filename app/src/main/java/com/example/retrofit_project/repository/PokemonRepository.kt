package com.example.retrofit_project.repository

import com.example.retrofit_project.model.PokemonDetailResponse
import com.example.retrofit_project.model.PokemonListResponse
import com.example.retrofit_project.remote.RemoteDataSource

/**
 * PokemonRepository acts as an intermediary between the ViewModel and the RemoteDataSource.
 *
 * It encapsulates the logic for fetching Pokémon data from the remote API, providing methods
 * to retrieve a paginated list of Pokémon, detailed information for a specific Pokémon, and
 * search for Pokémon by exact name or ID.
 */
class PokemonRepository(
    private val remoteDataSource: RemoteDataSource
) {

    /**
     * Retrieves a paginated list of Pokémon from the PokeAPI.
     *
     * @param offset The starting index for the Pokémon list.
     * @param limit The maximum number of Pokémon to fetch (default is 20).
     * @return A [PokemonListResponse] containing the list of Pokémon along with pagination details.
     */
    suspend fun getPokemonPage(offset: Int, limit: Int = 20): PokemonListResponse {
        return remoteDataSource.fetchPokemonPage(offset, limit)
    }

    /**
     * Retrieves detailed information for a specific Pokémon by its URL.
     *
     * @param url The URL that points to the Pokémon's detail endpoint.
     * @return A [PokemonDetailResponse] containing detailed information about the Pokémon.
     */
    suspend fun getPokemonDetail(url: String): PokemonDetailResponse {
        return remoteDataSource.fetchPokemonDetail(url)
    }

    /**
     * Searches for a Pokémon by its exact name or ID.
     *
     * @param query The exact name or ID of the Pokémon.
     * @return A [PokemonDetailResponse] with detailed information about the found Pokémon.
     */
    suspend fun getPokemonByNameOrId(query: String): PokemonDetailResponse {
        return remoteDataSource.fetchPokemonByNameOrId(query)
    }
}
