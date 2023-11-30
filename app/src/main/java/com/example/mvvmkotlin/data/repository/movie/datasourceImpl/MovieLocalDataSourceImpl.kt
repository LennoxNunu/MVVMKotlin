package com.example.mvvmkotlin.data.repository.movie.datasourceImpl

import com.example.mvvmkotlin.data.db.MovieDao
import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDoa: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDoa.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDoa.saveMovie(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDoa.deleteAllMovies()
        }
    }

}