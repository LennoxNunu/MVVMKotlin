package com.example.mvvmkotlin.domain.repository


import com.example.mvvmkotlin.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}