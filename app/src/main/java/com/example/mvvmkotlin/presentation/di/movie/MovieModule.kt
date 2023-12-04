package com.example.mvvmkotlin.presentation.di.movie

import com.example.mvvmkotlin.domain.usecase.GetMoviesUseCase
import com.example.mvvmkotlin.domain.usecase.UpdateMoviesUseCase
import com.example.mvvmkotlin.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}