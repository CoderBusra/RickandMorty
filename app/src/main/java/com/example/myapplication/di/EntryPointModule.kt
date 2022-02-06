package com.example.myapplication.di

import com.example.myapplication.data.api.Api
import com.example.myapplication.data.repository.CharacterRepository
import com.example.myapplication.data.repository.CharacterRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object EntryPointModule {

    @Provides
    fun providesRepository(
        api: Api
    ): CharacterRepository {
        return CharacterRepositoryImp(api)
    }

}