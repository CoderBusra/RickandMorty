package com.example.myapplication.data.model

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName

data class CharacterRickMortyList(
    @SerializedName("results")
    val results: List<CharacterRickMorty>
)
