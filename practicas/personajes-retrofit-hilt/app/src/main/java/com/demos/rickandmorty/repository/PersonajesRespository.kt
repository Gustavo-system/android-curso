package com.demos.rickandmorty.repository

import com.demos.rickandmorty.api.ApiService
import com.demos.rickandmorty.models.PersonajesResponse
import javax.inject.Inject

class PersonajesRespository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPersonajes(): PersonajesResponse {
        return apiService.getPersonajes()
    }

}