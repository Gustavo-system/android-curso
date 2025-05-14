package com.example.movieapp.core

sealed class Resource<out T> {
    // clase generada para las peticiones en los 3 estados
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure(val exception: Exception): Resource<Nothing>()
}