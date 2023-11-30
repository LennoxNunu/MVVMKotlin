package com.example.mvvmkotlin.data.repository.movie.datasource

import com.example.mvvmkotlin.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}