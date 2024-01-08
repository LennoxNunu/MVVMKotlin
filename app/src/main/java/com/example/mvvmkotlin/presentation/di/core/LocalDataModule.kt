package com.example.mvvmkotlin.presentation.di.core

import com.example.mvvmkotlin.data.db.ArtistDao
import com.example.mvvmkotlin.data.db.MovieDao
import com.example.mvvmkotlin.data.db.TvShowDao
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmkotlin.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmkotlin.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }


}