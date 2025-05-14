package com.example.movieapp.repository

import com.example.movieapp.data.models.MovieResult

interface MovieRepository {
    suspend fun getUpcomingMovies() : MovieResult
    suspend fun getTopMovies() : MovieResult
    suspend fun getPopularMovies() : MovieResult
}