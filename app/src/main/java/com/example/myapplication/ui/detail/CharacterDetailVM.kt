package com.example.myapplication.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.CharacterRickMorty
import com.example.myapplication.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CharacterDetailVM @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {

    var characterData = MutableLiveData<CharacterRickMorty>()

    fun getDetail(characterId: Int) {
        viewModelScope.launch {
            try {
                var response = repository.getCharacterDetail(characterId)
                characterData.postValue(response)
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }
}