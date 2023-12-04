package com.example.mvvmkotlin.presentation.di.tvshow

import com.example.mvvmkotlin.domain.usecase.GetTvShowsUseCase
import com.example.mvvmkotlin.domain.usecase.UpdateTvShowsUseCase
import com.example.mvvmkotlin.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}