package com.example.mvvmkotlin.domain.usecase

import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}