package com.example.movieapp.data.remote

import com.example.movieapp.application.AppConstants
import com.example.movieapp.data.models.MovieResult
import com.example.movieapp.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getMoviesUpcoming() : MovieResult = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopMovies() : MovieResult = webService.getTopMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies() : MovieResult = webService.getPopularMovies(AppConstants.API_KEY)


}