package com.example.myapplication.data.repository

import com.example.myapplication.data.model.CharacterRickMortyList
import com.example.myapplication.data.model.CharacterRickMorty
import retrofit2.Response

interface CharacterRepository {
    suspend fun getLists(): Response<CharacterRickMortyList>
    suspend fun getCharacterDetail(characterId:Int):CharacterRickMorty
}