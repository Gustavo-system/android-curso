package com.demos.rickandmorty.api

import com.demos.rickandmorty.models.PersonajesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getPersonajes(): PersonajesResponse
}