package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActVM @Inject constructor(private val characterRepository: CharacterRepository) : ViewModel() {

}