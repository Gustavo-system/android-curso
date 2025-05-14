package com.example.movieapp.repository

import com.example.movieapp.data.models.MovieResult
import com.example.movieapp.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieResult = dataSource.getMoviesUpcoming()

    override suspend fun getTopMovies(): MovieResult = dataSource.getTopMovies()

    override suspend fun getPopularMovies(): MovieResult = dataSource.getPopularMovies()
}