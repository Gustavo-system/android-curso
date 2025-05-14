package com.example.movieapp.repository

import com.example.movieapp.application.AppConstants
import com.example.movieapp.data.models.MovieResult
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey:String) : MovieResult

    @GET("movie/top_rated")
    suspend fun getTopMovies(@Query("api_key") apiKey:String) : MovieResult

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String) : MovieResult
}

object RetrofitClient {
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}