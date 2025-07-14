package com.demos.rickandmorty.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demos.rickandmorty.models.Results
import com.demos.rickandmorty.repository.PersonajesRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonajesViewModel @Inject constructor(private val repository : PersonajesRespository) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Results>())
    val state: StateFlow<List<Results>> get() = _state


    init {
        viewModelScope.launch {
            _state.value = repository.getPersonajes().personajes
        }
    }

}