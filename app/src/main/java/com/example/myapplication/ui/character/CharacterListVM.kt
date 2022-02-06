package com.example.myapplication.ui.character

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
class CharacterListVM @Inject constructor(private val characterRepository: CharacterRepository) :
    ViewModel() {

    var model = MutableLiveData<String>()
    var listLiveData = MutableLiveData<List<CharacterRickMorty>>()

    init {
        getList()
    }


    fun getList() {
        viewModelScope.launch {
            try {
                listLiveData.postValue(characterRepository.getLists().body()?.results)
            } catch (e: Exception) {

            }

        }
    }
}