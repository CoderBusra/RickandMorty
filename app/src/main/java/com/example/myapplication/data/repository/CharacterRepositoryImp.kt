package com.example.myapplication.data.repository

import com.example.myapplication.data.model.CharacterRickMortyList
import com.example.myapplication.data.api.Api
import com.example.myapplication.data.model.CharacterRickMorty
import retrofit2.Response
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
   private val api: Api
):CharacterRepository {
    override suspend fun getLists(): Response<CharacterRickMortyList> {
      return  api.getAllCharacters()
    }

    override suspend fun getCharacterDetail(characterId:Int): CharacterRickMorty {
        return api.getCharacters(characterId)
    }

}