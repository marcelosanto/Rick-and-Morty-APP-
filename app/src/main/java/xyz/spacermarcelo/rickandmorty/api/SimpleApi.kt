package xyz.spacermarcelo.rickandmorty.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.spacermarcelo.rickandmorty.api.model.CharacterList

interface SimpleApi {

    @GET("api/character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterList>
}