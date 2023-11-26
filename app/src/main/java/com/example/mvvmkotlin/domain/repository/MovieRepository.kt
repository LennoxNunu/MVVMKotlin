package com.example.mvvmkotlin.domain.repository

import com.example.mvvmkotlin.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}