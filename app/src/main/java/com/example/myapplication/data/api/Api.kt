package com.example.myapplication.data.api

import com.example.myapplication.data.model.CharacterRickMortyList
import com.example.myapplication.data.model.CharacterRickMorty
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterRickMortyList>

    @GET("character/{id}")
    suspend fun getCharacters(@Path("id")  id:Int): CharacterRickMorty

}