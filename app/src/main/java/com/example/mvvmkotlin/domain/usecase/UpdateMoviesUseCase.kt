package com.example.mvvmkotlin.domain.usecase

import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}