package xyz.spacermarcelo.rickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import xyz.spacermarcelo.rickandmorty.api.model.CharacterList
import xyz.spacermarcelo.rickandmorty.api.repository.Repository

class SharedViewModel(val repository: Repository) : ViewModel() {

    var listCharacters = MutableLiveData<Response<CharacterList>>()

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            listCharacters.value = characters
        }
    }

}