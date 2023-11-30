package com.example.mvvmkotlin.data.repository.movie.datasource

import com.example.mvvmkotlin.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}