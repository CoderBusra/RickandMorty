package com.example.myapplication.ui.adapter

import com.example.myapplication.data.model.CharacterRickMorty

interface CharacterClickListener {
    fun itemClick(characterRick: CharacterRickMorty)
}