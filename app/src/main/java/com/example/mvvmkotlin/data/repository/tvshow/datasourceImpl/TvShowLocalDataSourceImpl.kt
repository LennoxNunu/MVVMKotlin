package com.example.mvvmkotlin.data.repository.tvshow.datasourceImpl

import com.example.mvvmkotlin.data.db.MovieDao
import com.example.mvvmkotlin.data.db.TvShowDao
import com.example.mvvmkotlin.data.model.movie.Movie
import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.example.mvvmkotlin.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDoa: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDoa.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDoa.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDoa.deleteAllTvShows()
        }
    }

}