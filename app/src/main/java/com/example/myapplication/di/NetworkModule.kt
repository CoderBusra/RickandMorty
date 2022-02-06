package com.example.myapplication.di

import com.example.myapplication.data.api.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn


import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    
    @Provides
    fun provideAnalyticsService(
        gson: Gson,
        @AuthInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): Api {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
    }

    @AuthInterceptorOkHttpClient
    @Provides
    fun provideAuthInterceptorOkHttpClient(
    ): OkHttpClient {
        return OkHttpClient.Builder().let { builder: OkHttpClient.Builder ->

            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
                builder.addInterceptor(this)
            }
            builder.build()
        }
    }


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()



    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class OtherInterceptorOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthInterceptorOkHttpClient

}