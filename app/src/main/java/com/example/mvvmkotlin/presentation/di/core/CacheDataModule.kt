package com.example.mvvmkotlin.presentation.di.core

import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmkotlin.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmkotlin.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}