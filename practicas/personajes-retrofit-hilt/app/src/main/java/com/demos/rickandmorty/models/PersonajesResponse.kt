package com.demos.rickandmorty.models

import com.google.gson.annotations.SerializedName

data class PersonajesResponse (
    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var personajes : ArrayList<Results> = arrayListOf()
)