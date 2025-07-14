package com.demos.rickandmorty.models

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("name" ) var name : String =  "",
    @SerializedName("url"  ) var url  : String? = null

)