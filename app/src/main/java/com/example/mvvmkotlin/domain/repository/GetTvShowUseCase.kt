package com.example.mvvmkotlin.domain.repository

import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.example.mvvmkotlin.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}