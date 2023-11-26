package com.example.mvvmkotlin.domain.repository

import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}