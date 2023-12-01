package com.example.mvvmkotlin.data.repository.tvshow.datasource

import com.example.mvvmkotlin.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}