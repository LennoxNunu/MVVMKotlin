package com.example.mvvmkotlin.presentation.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.example.mvvmkotlin.data.repository.tvshow.FakeTvShowRepositoryImpl
import com.example.mvvmkotlin.domain.usecase.GetTvShowsUseCase
import com.example.mvvmkotlin.domain.usecase.UpdateTvShowsUseCase
import com.example.mvvmkotlin.getOrAwaitValue
import com.google.common.truth.Truth.assertThat


import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp_returnsCurrentList(){
        val fakeTvShowRepository = FakeTvShowRepositoryImpl()
        val getTvShowsUsecase = GetTvShowsUseCase(fakeTvShowRepository)
        val updateTvShowsUsecase = UpdateTvShowsUseCase(fakeTvShowRepository)
        viewModel = TvShowViewModel(getTvShowsUsecase,updateTvShowsUsecase)
    }

    @Test
    fun getTvShows_returnsUpdatedList(){
        val tvShows = mutableListOf<TvShow>()
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))

        val currentList = viewModel.getTvShows().getOrAwaitValue()
        assertThat(currentList).isEqualTo(tvShows)
    }

    @Test
    fun updateTvShows() {
        val tvShows = mutableListOf<TvShow>()
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))

        val updatedList = viewModel.updateTvShows().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(tvShows)
    }
}