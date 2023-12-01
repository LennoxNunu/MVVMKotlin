package com.example.mvvmkotlin.data.repository.tvshow.datasource

import com.example.mvvmkotlin.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCathe():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}