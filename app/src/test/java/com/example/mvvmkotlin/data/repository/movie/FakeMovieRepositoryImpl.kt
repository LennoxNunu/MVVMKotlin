package com.example.mvvmkotlin.data.repository.movie

import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.domain.repository.MovieRepository

class FakeMovieRepositoryImpl: MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", "path1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "path2", "date2", "title2"))
    }

    override suspend fun getMovies(): List<Movie>? {
       return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3, "overview3", "path3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "path4", "date4", "title4"))
        return movies
    }
}