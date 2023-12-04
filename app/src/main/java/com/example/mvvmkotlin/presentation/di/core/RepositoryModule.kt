package com.example.mvvmkotlin.presentation.di.core

import com.example.mvvmkotlin.data.repository.artist.ArtistRepositoryImpl
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.mvvmkotlin.data.repository.movie.MovieRepositoryImpl
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.mvvmkotlin.data.repository.tvshow.TvShowRepositoryImpl
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.mvvmkotlin.domain.repository.ArtistRepository
import com.example.mvvmkotlin.domain.repository.MovieRepository
import com.example.mvvmkotlin.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}