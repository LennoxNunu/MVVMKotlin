package com.example.mvvmkotlin.data.repository.movie.datasourceImpl

import com.example.mvvmkotlin.data.api.TMDBService
import com.example.mvvmkotlin.data.model.movie.MovieList
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
    ) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apikey)
}