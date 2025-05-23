package com.example.movieapp.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val adult            : Boolean?       = null,
    @SerializedName(value = "backdrop_path")
    val backdropPath     : String?        = null,
    @SerializedName(value = "genre_ids")
    val genreIds         : List<Int> = listOf(),
    val id               : Int?           = null,
    @SerializedName(value = "original_language")
    val originalLanguage : String?        = null,
    @SerializedName(value = "original_title")
    val originalTitle    : String?        = null,
    val overview         : String?        = null,
    val popularity       : Double?        = null,
    @SerializedName(value = "poster_path")
    val posterPath       : String?        = null,
    @SerializedName(value = "release_date")
    val releaseDate      : String?        = null,
    val title            : String?        = null,
    val video            : Boolean?       = null,
    @SerializedName(value = "vote_average")
    val voteAverage      : Double?        = null,
    @SerializedName(value = "vote_count")
    val voteCount        : Int?           = null
)

data class MovieResult(
    val results : List<Movie> = listOf()
)