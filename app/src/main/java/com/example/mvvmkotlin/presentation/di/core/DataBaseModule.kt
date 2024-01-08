package com.example.mvvmkotlin.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.example.mvvmkotlin.data.db.ArtistDao
import com.example.mvvmkotlin.data.db.MovieDao
import com.example.mvvmkotlin.data.db.TMDBDatabase
import com.example.mvvmkotlin.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application):TMDBDatabase{
        return Room.databaseBuilder(app,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

}