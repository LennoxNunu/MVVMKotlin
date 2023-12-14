package com.example.mvvmkotlin.presentation.artist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.data.repository.artist.FakeArtistRepositoryImpl
import com.example.mvvmkotlin.domain.usecase.GetArtistsUseCase
import com.example.mvvmkotlin.domain.usecase.UpdateArtistsUseCase
import com.example.mvvmkotlin.getOrAwaitValue
import com.google.common.truth.Truth.assertThat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ArtistViewModel

    @Before
    fun setUp() {
        val fakeArtistRepository = FakeArtistRepositoryImpl()
        val getArtistsUsecase = GetArtistsUseCase(fakeArtistRepository)
        val updateArtistsUsecase = UpdateArtistsUseCase(fakeArtistRepository)
        viewModel = ArtistViewModel(getArtistsUsecase,updateArtistsUsecase)
    }

    @Test
    fun getArtists_returnsCurrentList(){
        val artists = mutableListOf<Artist>()
        artists.add(Artist(1,"name1",0.1,"profilePath1"))
        artists.add(Artist(2,"name2",0.2,"profilePath2"))

        val currentList = viewModel.getArtists().getOrAwaitValue()
        assertThat(currentList).isEqualTo(artists)
    }

    @Test
    fun updateArtists_returnsUpdatedList(){
        val artists = mutableListOf<Artist>()
        artists.add(Artist(3,"name3",0.3,"profilePath3"))
        artists.add(Artist(4,"name4",0.4,"profilePath4"))

        val updatedList = viewModel.updateArtists().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(artists)
    }
}