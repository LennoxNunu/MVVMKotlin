package com.example.mvvmkotlin.data.repository.movie.datasourceImpl

import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCathe(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}