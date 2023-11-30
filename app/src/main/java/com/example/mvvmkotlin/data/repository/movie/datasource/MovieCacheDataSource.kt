package com.example.mvvmkotlin.data.repository.movie.datasource

import com.example.mvvmkotlin.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCathe():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}