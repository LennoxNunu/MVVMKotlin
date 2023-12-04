package com.example.mvvmkotlin.presentation.di.artist

import com.example.mvvmkotlin.domain.usecase.GetArtistsUseCase
import com.example.mvvmkotlin.domain.usecase.UpdateArtistsUseCase
import com.example.mvvmkotlin.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}