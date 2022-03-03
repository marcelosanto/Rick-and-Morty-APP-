package xyz.spacermarcelo.rickandmorty.api.repository

import retrofit2.Response
import xyz.spacermarcelo.rickandmorty.api.RetrofitInstance
import xyz.spacermarcelo.rickandmorty.api.model.CharacterList

class Repository {

    suspend fun getCharacters(page: Int): Response<CharacterList> {
        return RetrofitInstance.api.getCharacters(page)
    }
}