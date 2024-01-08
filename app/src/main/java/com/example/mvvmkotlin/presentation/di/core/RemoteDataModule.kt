package com.example.mvvmkotlin.presentation.di.core

import com.example.mvvmkotlin.BuildConfig
import com.example.mvvmkotlin.data.api.TMDBService
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.mvvmkotlin.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.mvvmkotlin.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.mvvmkotlin.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }


}